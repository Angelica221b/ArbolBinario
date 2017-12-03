package app;

import Escuela.Alumno;
import btree.btree;
import node.node;

public class App {

	public static void main(String[] args) {
		btree<Integer> numeritos = new btree<Integer>();
		numeritos.add(5);
		numeritos.add(-1);
		numeritos.add(0);
		numeritos.add(24);
		numeritos.add(-6);
		numeritos.add(5);
		numeritos.add(9);
		numeritos.add(30);
		//numeritos.add(35);
		//numeritos.add(27);
		
		
		
		
		System.out.println("--Inorder");
		numeritos.printInorder();
		System.out.println("---------------------");
		System.out.println();
		
		System.out.println("--Preorder--");
		numeritos.printPreorder();
		System.out.println("---------------------");
		System.out.println();
		
		System.out.println("--Postorder--");
		numeritos.printPostOrder();
		
		
		System.out.println("--");
		
		//
		System.out.println("Busqueda por amplitud");
		node<Integer> nodo=new node <Integer>();
		nodo.setValue(0);
		
		System.out.println("Buscar "+nodo.getValue()+": "+numeritos.breadthSearch(nodo));
		System.out.println("------------------------");
		System.out.println("Recorrido por amplitud");
		numeritos.recorridoAmpitud();
		
		System.out.println();
		System.out.println("------------------------");
		System.out.println("Busqueda en profundidad");
		System.out.println("Buscar numero: "+numeritos.deepSearch(-6).getValue());
		
		System.out.println();
		System.out.println("------------------------");
		
		System.out.println("maxDepth: "+numeritos.maxDepth());
		System.out.println("Exise número 24: "+numeritos.exists(24));
		
		numeritos.clear();
		
		System.out.println("------------------------");
		System.out.println("PosOrder");
		numeritos.printPostOrder();
		System.out.println();
		System.out.println("------------------------");
		System.out.println("maxDepth: "+numeritos.maxDepth());
		
		//System.out.println("---"+numeritos.deepSearch(5).getValue());
		//System.out.println(numeritos.deepSearch(9).getValue());
		
		//node<Integer> tmp = numeritos.isChild(9);
		//if(tmp != null)System.out.println(tmp.getValue());
		
		/*btree<String> letras = new btree<String>();
		letras.add("a");
		letras.add("d");
		letras.add("b");
		letras.add("c");
		letras.add("h");
		System.out.println("-----String-----");
		letras.printInorder();*/
		
				
		/*btree<Double> numeros = new btree<Double>();
		numeros.add(10.5);
		numeros.add(10.1);
		numeros.add(10.2);
		System.out.println("-----Double-----");
		numeros.printInorder();*/
		
		/*btree<Alumno> alumno = new btree<Alumno>();
		alumno.add(new Alumno("pablo",10d));
		alumno.add(new Alumno("Juan",9d));
		alumno.add(new Alumno("yon",8d));
		System.out.println("-----Alumno-----");
		alumno.printInorder();*/

	}

}
