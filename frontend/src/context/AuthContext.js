import { createContext, useState, useEffect } from "react";
import { login, logout } from "../services/authService";

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const storedUser = localStorage.getItem("token");
    if (storedUser) setUser(storedUser);
  }, []);

  const handleLogin = async (email, password) => {
    const data = await login(email, password);
    setUser(data.user);
    localStorage.setItem("token", data.token);
  };

  const handleLogout = () => {
    logout();
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, handleLogin, handleLogout }}>
      {children}
    </AuthContext.Provider>
  );
};


