package btree;

import Queue.Queue;
import node.node;

public class btree<T extends Comparable<T>> implements Comparable<T> {

	private node<T> root = null;
	private int heigh = 0;
	private int count=0,cont=0;

	public btree() {
		//this.root = new node<>();
		this(null);
	}

	public btree(T value) {
		//this();
		this.root = new node<>();
		root.setValue(value);
		
	}

	public void add(T value) {
		if (root.getValue() == null)
		//if(isEmpty())
		root.setValue(value);
		else
			add(value, root);
	}

	private void add(T value, node<T> root) {
		if (root.getValue().compareTo(value) >= 1) {
			if (root.getLeft() == null) {
				root.setLeft(new node<>(value));
				count++;
				return;
			} else
				add(value, root.getLeft());
		} else if (root.getValue().compareTo(value) <= -1 || root.getValue().compareTo(value) == 0) {
			if (root.getRight() == null) {
				root.setRight(new node<>(value));
				count++;
				return;
			} else
				add(value, root.getRight());

		}
	}

	public boolean remove(T value) {
		node<T> tmp = deepSearch(value);
		if (tmp != null)
			return remove(value, tmp, isChild(value));
		return false;
	}

	private boolean remove(T value, node<T> root, node<T> imyourfather) {
		if (isChild(value) == null) {
			node<T> miNode = minSearch(root.getRight());
			miNode.setLeft(root.getLeft());
			this.root = root.getRight();
			return true;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			if (imyourfather.getLeft() != null && imyourfather.getLeft().equals(root))
				imyourfather.setLeft(null);
			else if (imyourfather.getRight() != null)
				imyourfather.setRight(null);
			return true;
		} else if (root.getLeft() != null && root.getRight() == null) {
			if (imyourfather.getLeft().equals(root))
				imyourfather.setLeft(root.getLeft());
			else
				imyourfather.setRight(root.getLeft());
			return true;
		} else if (root.getLeft() == null && root.getRight() != null) {
			if (imyourfather.getLeft().equals(root))
				imyourfather.setLeft(root.getRight());
			else
				imyourfather.setRight(root.getRight());
			return true;
		} else {
			if (imyourfather.getLeft().equals(root)) {
				node<T> left = minSearch(root.getRight());
				left.setLeft(root.getLeft());
				imyourfather.setLeft(root.getRight());
			} else {
				node<T> left = minSearch(root.getRight());
				left.setLeft(root.getLeft());
				imyourfather.setRight(root.getRight());
			}

			return true;
		}
		// return false;
	}

	public void printInorder() {
		printInorder(root);
	}

	private void printInorder(node<T> root) {
		if(!isEmpty()){
			if (root.getLeft() != null)
				printInorder(root.getLeft());
	
			System.out.println(root.getValue().toString());
	
			if (root.getRight() != null)
				printInorder(root.getRight());
		}
	}





	public node<T> isChild(T value) {
		if (deepSearch(value) == null)
			return null;
		return isChild(value, root, null);
	}

	private node<T> isChild(T value, node<T> root, node<T> imyourfather) {
		if (root != null) {
			if (root.getValue().equals(value))
				return imyourfather;
			if (root.getValue().compareTo(value) <= -1)
				return isChild(value, root.getRight(), root);
			else
				return isChild(value, root.getLeft(), root);
		} else
			return null;
	}
	

	private node<T> minSearch(node<T> root) {
		while (root.getLeft() != null)
			root = root.getLeft();

		return root;
	}

	private node<T> maxSearch(node<T> root) {
		while (root.getRight() != null)
			root = root.getRight();

		return root;
	}

	//------------------ Tarea ----------------------
	
	//PostOrder
	public void printPostOrder() {
		printPostOrder(root);
	}
	
	private void printPostOrder(node<T> root){
		if(!isEmpty()){
			if (root.getLeft() != null && root.getRight() != null)
				
				printInorder(root.getLeft());
				printInorder(root.getRight());
				System.out.println(root.getValue().toString());
		}
	}
	
	//Preorder
	public void printPreorder() {
		printPreorder(root);
	}

	private void printPreorder(node<T> root) {
		if(!isEmpty()){
			if (root.getLeft() != null && root.getRight() != null)
				System.out.println(root.getValue().toString());
	
			printInorder(root.getLeft());
	
			printInorder(root.getRight());
		}
	}
	
	//Esta vacio
	private boolean isEmpty() {
		return (root == null);
	}

	public node<T> deepSearch(T value) {// busqueda profunda

		return deepSearch(value, root);
		
	}
	
	//Busqueda en profundidad
	private node<T> deepSearch(T value, node<T> root) {
		
		if (root != null) {
			
			if (root.getValue().equals(value)){
				return root;
			}
			
			if (root.getValue().compareTo(value) <= -1){
				return deepSearch(value, root.getRight());
			}
			else{
				return deepSearch(value, root.getLeft());
			}
			
		} else{
			
			return null;
		}
	}

	
	//Busqueda en amplitud
	public boolean breadthSearch(node<T>value) {
		Queue<node<T>> cola = new Queue<node<T>>(++count);
		try {
			cola.enQueue(root);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(cont!=cola.size()){
			node<T> nodo;
			try {
				
				nodo = cola.deQueue();
				//System.out.println("Nodo => "+nodo.getValue());
				if(nodo.getValue().equals(value.getValue())){
					return true;
				}else{
					if(nodo.getLeft()!=null){
						
						cola.enQueue(nodo.getLeft());
						
					}
					if(nodo.getRight()!=null){
						
						cola.enQueue(nodo.getRight());
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	//Recorrido por amplitud
	public void recorridoAmpitud(){
		Queue<node<T>> cola = new Queue<node<T>>(++count);
		try {
			cola.enQueue(root);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(cont!=cola.size()){
			node<T> nodo;
			try {
				
				nodo = cola.deQueue();
				System.out.println("Nodo => "+nodo.getValue());
				if(nodo.getLeft()!=null){
						
					cola.enQueue(nodo.getLeft());
						
				}
				if(nodo.getRight()!=null){
						
					cola.enQueue(nodo.getRight());
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	
	private int max(node<T> root) {
		if(root==null)
			return -1;
		else{
			int left=max(root.getLeft());
			int right=max(root.getRight());
			
			if(left>right)
				return(left+1);
			else
				return(right+1); 
		}
			
	}
	
	public int maxDepth(){
		return(max(root));
	}

	public void clear() {
		root = null;
	}

	public boolean exists(T value) {
		
		if(deepSearch(value)!=null){
			return true;
		}else
			return false;
			
	}
	
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
