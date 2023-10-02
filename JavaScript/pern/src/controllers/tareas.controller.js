import {pool} from "../db.js";

export const listarTareas = (req, res) => res.send("Obteniendo tareas");

export const listarTarea = (req, res) => res.send("Obteniendo tarea única");

export const crearTarea = async(req, res) => {
    const { titulo, descripcion } = req.body;

    try {
        const resultado = await pool.query("INSERT INTO tareas (titulo, descripcion) VALUES ($1, $2) RETURNING *", [titulo, descripcion]);
        res.json(resultado.rows[0]);
        console.log(resultado.rows[0])
    } catch (e) {

        if (e.code === "23505") {
            return res.send("Ya existe una tarea con ese titulo");
        }
        console.log(e);
        next(e);
    }
};

export const actualizarTareas = (req, res) => res.send("Actualizando tarea única");

export const eliminarTareas = (req, res) => res.send("Eliminando tarea única");
