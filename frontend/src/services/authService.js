import api from "./api";

export const login = async (email, password) => {
  try {
    const response = await api.post("/auth/login", { email, password });
    return response.data;
  } catch (error) {
    throw error.response?.data || "Erro ao fazer login";
  }
};

export const register = async (name, email, password) => {
  try {
    const response = await api.post("/auth/register", { name, email, password });
    return response.data;
  } catch (error) {
    throw error.response?.data || "Erro ao registrar";
  }
};

export const logout = () => {
  localStorage.removeItem("token");
};
