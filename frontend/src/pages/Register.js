import RegisterForm from "../components/RegisterForm";

const Register = () => {
  return (
    <div>
      <h1>Registrar</h1>
      <RegisterForm onRegister={(user) => console.log("Usuário registrado:", user)} />
    </div>
  );
};

export default Register;
