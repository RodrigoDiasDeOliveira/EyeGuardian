import { Link } from "react-router-dom";
import "./Navbar.css"; // Arquivo de estilo para o navbar

const Navbar = () => {
  return (
    <nav className="navbar">
      <h2>EyeGuardian</h2>
      <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/login">Login</Link></li>
        <li><Link to="/register">Register</Link></li>
        <li><Link to="/dashboard">Dashboard</Link></li>
        <li><Link to="/profile">Profile</Link></li>
      </ul>
    </nav>
  );
};

export default Navbar;
