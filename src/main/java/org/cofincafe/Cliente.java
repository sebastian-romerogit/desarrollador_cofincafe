package org.cofincafe;

public record Cliente(int id, String nombre, double balance) {

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', balance=" + balance + "}";
    }
}

