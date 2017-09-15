package ua.nure.poliakov.Practice6.task4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Map<Object, HashSet<Object>> list;

    private int countVertex;

    public Graph(int countVertex) {
        this.countVertex = countVertex;
        list = new HashMap<>(countVertex);
    }

    public void addVertex(int vertex) {
        if (list.containsKey(vertex)) {
            System.out.println("Vertex already exist");
        }
        if (list.size() < countVertex) {
            list.put(vertex, new HashSet<>());
        }
    }

    public void addEdge(Integer vertex1, Integer vertex2) {
        if (!list.containsKey(vertex1) || !list.containsKey(vertex2)) {
            System.out.println("Illegal arguments");
        }
        if (list.size() < countVertex) {
            list.get(vertex1).add(vertex2);
            list.get(vertex2).add(vertex1);
        }
    }

    public void removeVertex(int vertex) {
        if (!this.list.containsKey(vertex)) {
            System.out.println("Vertex doesn't exist");
        }
        list.remove(vertex);
    }

    public void removeEdge(Integer vertex1, Integer vertex2) {
        if (!list.containsKey(vertex1) || !list.containsKey(vertex2)) {
            System.out.println("Illegal arguments");
        }
        removeVertex(vertex1);
        removeVertex(vertex2);
    }

    public Set<Object> getPair(Integer vertex) {
        return this.list.get(vertex);
    }

    public Set<Object> getList() {
        return list.keySet();
    }
}