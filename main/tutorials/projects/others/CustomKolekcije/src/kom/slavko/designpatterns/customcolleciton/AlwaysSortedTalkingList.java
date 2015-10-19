package kom.slavko.designpatterns.customcolleciton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AlwaysSortedTalkingList<E> implements List<E>{
	
	
	    private Comparator<E> comparator;
	    private ArrayList<E> list;
	        
	    public AlwaysSortedTalkingList(Comparator<E> c)
	    {
	    	
	        this.list = new ArrayList<E>();
	        this.comparator = c;
	        System.out.println("Initialised");
	    }	 

	    public Comparator<E> getComparator() { return comparator; }
	    public void setComparator(Comparator<E> cmp) { comparator = cmp; sortThis(); }  
	    	    	   
	    
	    private void sortThis()
	    {
	        Collections.sort(list, comparator);
	    }
		@Override
		public void add(int index, E e) {
			list.add(e); sortThis();
			System.out.println("You've added an element");
		}
		@Override
		public boolean addAll(int index, Collection<? extends E> c) {
			throw new UnsupportedOperationException();
		}
		@Override
		public E get(int index) {
			System.out.println("Element with index "+index+" is "+ list.get(index));
			return list.get(index);
		}
		@Override
		public int indexOf(Object o) {
			throw new UnsupportedOperationException();
		}
		@Override
		public int lastIndexOf(Object o) {
			throw new UnsupportedOperationException();
		}
		@Override
		public ListIterator<E> listIterator() {
			return list.listIterator();
		}
		@Override
		public ListIterator<E> listIterator(int index) {
			return list.listIterator(index);
		}
		@Override
		public E remove(int index) {
			E r = list.remove(index); sortThis();
			System.out.println("You've removed " + r);
			return r;
		}
		@Override
		public E set(int index, E element) {
			throw new UnsupportedOperationException();
		}
		@Override
		public List<E> subList(int fromIndex, int toIndex) {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean add(E e) {
			System.out.println("You've added an element");
			list.add(e);
			sortThis();
			return true;
		}
		@Override
		public boolean addAll(Collection<? extends E> c) {
			throw new UnsupportedOperationException();
		}
		@Override
		public void clear() {
			System.out.println("You've cleared entire list");
			list.clear();
			
		}
		@Override
		public boolean contains(Object o) {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean containsAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean isEmpty() {
			if(list.isEmpty())
				System.out.println("List is empty");
			else
				System.out.println("List is not empty");
			return list.isEmpty();
		}
		@Override
		public Iterator<E> iterator() {
			return list.iterator();
		}
		@Override
		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean removeAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}
		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}
		@Override
		public int size() {
			System.out.println("Size: " + list.size());
			return list.size();
		}
		@Override
		public Object[] toArray() {
			throw new UnsupportedOperationException();
		}
		@Override
		public <T> T[] toArray(T[] a) {
			throw new UnsupportedOperationException();
		}	
	
}
