package interview;

public class pivotal<T> {
      private T array[];
      int size;
      int capacity;

      public pivotal(){
    	  array = (T[]) new Object[1];
    	  size = 0;
    	  capacity = 0;
      }

      public pivotal(T[] element){
          array = element;
          size = array.length;
          capacity = array.length;
      }

      /**
       *add element to set. A check is made to identify whether element is present or not.
       *If not the element can be inserted.
       * @param element
       */
      public void add(T element) {
            if(!contains(element)){
	            if(size == array.length){
	            	resize();
	            }
	            array[size++] = element;
            }
      }

      /**
       * to check is element is present or not.
       * @param elem
       * @return boolean
       */
      public boolean contains(T elem){
            if (elem == null) {
                for (int i = 0; i < size; i++)
                  if (array[i]==null)
                      return true;
            } else {
                for (int i = 0; i < size; i++)
                  if (elem.equals(array[i]))
                      return true;
            }
            return false;
      }
      
      public void remove(T element) {
    	  int count = 0;
    	  for(int i = 0; i < size; i++) {
    		  if (!element.equals(array[i])) {
                  array[count] = array[i];
                  count++;
    		  }
    	  }
    	  size = count;
      }

      /**
       * return the size of set.
       * @return int
       */
      public int size(){
          return size;
      }

      public void clear(){
          array = null;
          size = 0;
          capacity = 0;
      }

      public String toString(){
            if(array == null  || array.length == 0){
                  return "[EMPTY]";
            }else{
                  StringBuilder sb = new StringBuilder();
                  sb.append("[");
                  for(int i = 0; i < size; i++) {
                	  if(array[i] != null) {
	                	  if(i == size - 1) {
	                		  sb.append(array[i]);
	                	  } else {
	                		  sb.append(array[i] + ",");
	                	  }
                	  }
                  }
                  sb.append("]");
                  return sb.toString();
            }
      }	     

      /**
       * to check whether set is empty or not
       * @return
       */
      public boolean isEmpty(){
           return size == 0;
      }

      /**
       * this function is used to increment the size of an array
       *
       */
      private void resize() {
            T[] temparray = array;
            capacity = size+5;
            array = (T[]) new Object[capacity];
            System.arraycopy(temparray, 0, array, 0, size);
      }

	public static void main(String[] args) {
		pivotal<Integer> set = new pivotal<Integer>();
		set.add(0);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
		set.add(7);
		System.out.println(set.isEmpty());
		System.out.println(set.size());
		System.out.println(set.toString());
		System.out.println(set.contains(1));
		System.out.println(set.contains(2));
		System.out.println();
		
		set.remove(3);
		System.out.println(set.size());
		System.out.println(set.toString());
		System.out.println(set.contains(3));
		System.out.println(set.contains(4));
		System.out.println();
		
		set.remove(7);
		set.remove(6);
		set.remove(5);
		set.remove(4);
		set.remove(2);
		set.remove(1);
		set.remove(0);
		System.out.println(set.isEmpty());
		System.out.println(set.size());
		System.out.println(set.toString());
		System.out.println(set.contains(7));
		System.out.println(set.contains(6));
		System.out.println();
	}
}
