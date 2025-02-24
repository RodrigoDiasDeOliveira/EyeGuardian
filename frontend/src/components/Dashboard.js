import { useState, useEffect } from "react";
import axios from "axios";

const Dashboard = () => {
  const [objects, setObjects] = useState([]);
  const [error, setError] = useState("");

  useEffect(() => {
    fetchRecognizedObjects();
  }, []);

  const fetchRecognizedObjects = async () => {
    try {
      const response = await axios.get("http://localhost:8080/recognized-objects");
      setObjects(response.data);
    } catch (err) {
      setError("Erro ao carregar objetos.");
    }
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/recognized-objects/${id}`);
      setObjects(objects.filter((obj) => obj.id !== id));
    } catch (err) {
      setError("Erro ao excluir o objeto.");
    }
  };

  return (
    <div className="container mx-auto p-6">
      <h2 className="text-3xl font-bold mb-4">Objetos Reconhecidos</h2>
      {error && <p className="text-red-500">{error}</p>}
      {objects.length === 0 ? (
        <p>Nenhum objeto reconhecido.</p>
      ) : (
        <ul className="space-y-4">
          {objects.map((obj) => (
            <li key={obj.id} className="p-4 border rounded flex justify-between">
              <span>
                <strong>{obj.name}</strong>: {obj.description}
              </span>
              <button
                className="bg-red-500 text-white px-4 py-1 rounded hover:bg-red-700"
                onClick={() => handleDelete(obj.id)}
              >
                Excluir
              </button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default Dashboard;
