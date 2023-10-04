import Router from "express-promise-router";
import { listarTareas, listarTarea, crearTarea, actualizarTareas, eliminarTareas } from "../controllers/tareas.controller.js";
import { isAuth } from "../middlewares/auth.middleware.js";

const router = Router();

router.get("/tareas", isAuth, listarTareas);

router.get("/tareas/:id", isAuth, listarTarea);

router.post("/tareas", isAuth, crearTarea);

router.put("/tareas/:id", isAuth, actualizarTareas);

router.delete("/tareas/:id", isAuth, eliminarTareas);

export default router;
