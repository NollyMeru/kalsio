/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nodosr;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class NodosR {

  //hola si

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese la cantidad de nodos: ");
            int cantidadNodos = scanner.nextInt();

            System.out.println("Ingrese los valores de los nodos:");

            Nodo raiz = null;                             
            for (int i = 0; i < cantidadNodos; i++) {
                int valor = scanner.nextInt();
                raiz = insertar(raiz, valor);
            }

            System.out.println("Recorrido Posorden:");
            recorridoPosorden(raiz);
            System.out.println();

            System.out.println("Recorrido Enorden:");
            recorridoEnorden(raiz);
            System.out.println();

            System.out.println("Recorrido Preorden:");
            recorridoPreorden(raiz);
            System.out.println();
        }

        private static Nodo insertar(Nodo raiz, int valor) {
            if (raiz == null) {
                return new Nodo(valor);
            }

            if (valor < raiz.valor) {
                raiz.izquierdo = insertar(raiz.izquierdo, valor);
            } else if (valor > raiz.valor) {
                raiz.derecho = insertar(raiz.derecho, valor);
            }

            return raiz;
        }

        private static void recorridoPosorden(Nodo nodo) {
            if (nodo != null) {
                recorridoPosorden(nodo.izquierdo);
                recorridoPosorden(nodo.derecho);
                System.out.print(nodo.valor + " ");
            }
        }

        private static void recorridoEnorden(Nodo nodo) {
            if (nodo != null) {
                recorridoEnorden(nodo.izquierdo);
                System.out.print(nodo.valor + " ");
                recorridoEnorden(nodo.derecho);
            }
        }

        private static void recorridoPreorden(Nodo nodo) {
            if (nodo != null) {
                System.out.print(nodo.valor + " ");
                recorridoPreorden(nodo.izquierdo);
                recorridoPreorden(nodo.derecho);
            }
        }

        public static class Nodo {

            int valor;
            Nodo izquierdo;
            Nodo derecho;

            public Nodo(int valor) {
                this.valor = valor;
                izquierdo = null;
                derecho = null;
            }
        }

    }

