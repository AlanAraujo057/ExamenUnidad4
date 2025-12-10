async function createReport() {
        const name = document.getElementById("nombre").value;
        const email = document.getElementById("descripion").value;
        const respuesta = document.getElementById("respuesta");
        respuesta.innerHTML = "";

        const res = await fetch("/reports", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({ nombre, descripcion, fecha })
        });

        const datos = await res.json();

        if (!res.ok) {
            respuesta.innerHTML = "<span class='error'>Error</span>";
        } else {
            respuesta.innerHTML = "<span class='success'>Creado ID " + datos.id + "</span>";
        }
    }

    async function getReport() {
        const id = document.getElementById("id").value;
        const find = document.getElementById("find");

        find.innerHTML = "";

        const res = await fetch("/reports/" + id);

        if (!res.ok) {
            find.innerHTML = "<p class='error'>No encontrado</p>";
            return;
        }

        const u = await res.json();

        find.innerHTML = `
            <div class="card">
                <b>ID:</b> ${u.id}<br>
                <b>Nombre:</b> ${u.nombre}<br>
                <b>Descripcion:</b> ${u.descripcion}<br>
                <b>Fecha:</b> ${u.fecha}<br>
            </div>
        `;
    }

    async function deleteReport(id) {
        await fetch("/reports/" + id, { method: "DELETE" });
        loadReports();
    }
    async function loadReports() {
        const list = document.getElementById("list");
        list.innerHTML = "";
        const res = await fetch("/reports");
        const data = await res.json();
        data.forEach(u => {
            list.innerHTML += `
                <div class="card">
                    <b>ID:</b> ${u.id}<br>
                    <b>Nombre:</b> ${u.name}<br>
                    <b>Email:</b> ${u.email}<br>
                    <button onclick="deleteReport(${u.id})">Eliminar</button>
                </div>
            `;
        });
    }
