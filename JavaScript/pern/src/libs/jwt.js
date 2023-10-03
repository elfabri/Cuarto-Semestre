import { jwt } from "jsonwebtoken";

export const createAccessToken = (payload) => {
    return new Promise((res, rej) => {
        jwt.sign(payload, "xyz123", {expiresIn: "1d"},
        (err, token) => {
            if (err) rej(err);
            res(token);

        });
    });
}
