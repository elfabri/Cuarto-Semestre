import Card from '../components/ui/card.jsx';
import Input from '../components/ui/input.jsx';
import Button from '../components/ui/button.jsx'

function RegisterPage() {
    return (
        <div className="h-[clac(100vh-64px)] flex items-center justify-center">
            <Card>
                <h3 className='text-2x1 font-bold'>Registro</h3>
                <form >
                    <Input placeholder="Ingrese su nombre"/>
                    <Input type="email" placeholder="Ingrese su email"/>
                    <Input type="password" placeholder="Ingrese su contraseña"/>

                    <Button>Registrarse</Button>
                </form>
            </Card>
        </div>
    )
}

export default RegisterPage;
