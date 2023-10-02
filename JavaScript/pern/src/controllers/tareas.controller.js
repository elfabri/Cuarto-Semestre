import {pool} from "../db.js";

export const listarTareas = async (req, res) => {
    const resultado = await pool.query("SELECT * FROM tareas;");
    console.log(resultado);
    return res.json(resultado.rows);
}

export const listarTarea = async (req, res) => {
    const resultado = await pool.query("SELECT * FROM tareas WHERE id = $1", [req.params.id]);
    if (resultado.rowCount === 0) {
        return res.status(404).json({
            message: "La tarea no existe"
        });
    }
    return res.json(resultado.rows[0]);
}

export const crearTarea = async(req, res, next) => {
    const { titulo, descripcion } = req.body;

    try {
        const resultado = await pool.query("INSERT INTO tareas (titulo, descripcion) VALUES ($1, $2) RETURNING *", [titulo, descripcion]);
        res.json(resultado.rows[0]);
        console.log(resultado.rows[0])
    } catch (e) {

        if (e.code === "23505") {
            return res.status(409).json({
                message: "Ya existe una tarea con ese titulo"
            });
        }
        console.log(e);
        next(e);
    }
};

export const actualizarTareas = (req, res) => res.send("Actualizando tarea única");

export const eliminarTareas = async (req, res) => {
    const resultado = await pool.query("DELETE FROM tareas WHERE id = $1", [req.params.id])

    if (resultado.rowCount === 0) {
        return res.status(404).json({
            message: "No existe tarea con ese id"
        });
    }
    
    return res.sendStatus(204);
}
