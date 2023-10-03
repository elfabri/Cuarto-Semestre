import { pool } from "../db.js";

export const signin = (req, res) => res.send("Ingresando");

export const signup = async (req, res) => {
    const {name, email, password} = req.body;

    try {
        const result = await pool.query("INSERT INTO usuarios (name, email, password) VALUES ($1, $2, $3) RETURNING *", [name, email, password]);

        console.log(result);
        return res.json(result.rows[0]);
    } catch (e) {
        if (e.code === "23505") {
            return res.status(400).json({message: "El correo ya esta registrado"});
        }
    }
}

export const signout = (req, res) => res.send("Cerrando Sesión");

export const profile = (req, res) => res.send("Perfil de Usuario");
