import LoginForm from "../components/LoginForm";

const Login = () => {
  return (
    <div>
      <h1>Login</h1>
      <LoginForm onLogin={(user) => console.log("Usuário logado:", user)} />
    </div>
  );
};

export default Login;
