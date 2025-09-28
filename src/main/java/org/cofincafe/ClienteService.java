package org.cofincafe;

import java.util.*;
import java.util.stream.Collectors;
import org.json.JSONObject;
import org.json.JSONArray;

public class ClienteService {

    //Clientes con balance negativo
    public List<Cliente> obtenerClientesConBalanceNegativo(List<Cliente> clientes) {
        return clientes.stream()
                .filter(c -> c.balance() < 0)
                .collect(Collectors.toList());
    }

    //Top 3 clientes con mayor balance
    public List<Cliente> obtenerTopTresClientesConMayorBalance(List<Cliente> clients) {
        return clients.stream()
                .sorted(Comparator.comparingDouble(Cliente::balance).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<Cliente> obtenerTopClientesConMayorBalance(List<Cliente> clients, int top) {
        // Filtrar balances positivos
        List<Cliente> positivos = clients.stream()
                .filter(c -> c.balance() > 0)
                .sorted(Comparator.comparingDouble(Cliente::balance).reversed())
                .limit(top)
                .collect(Collectors.toList());

        // Rellenar si faltan registros
        while (positivos.size() < top) {
            int posicion = positivos.size() + 1;
            positivos.add(new Cliente(-1, "Sin registro válido (" + posicion + ")", 0.0));
        }

        return positivos;
    }


    //Convertir lista a JSON
    public  String convertirListaAJson(List<Cliente> clients) {
        JSONArray jsonArray = new JSONArray();
        for (Cliente c : clients) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", c.id());
            jsonObj.put("nombre", c.nombre());
            jsonObj.put("balance", c.balance());
            jsonArray.put(jsonObj);
        }
        return jsonArray.toString(2);
    }
}

