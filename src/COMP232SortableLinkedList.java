/**
 * A sortable DoublyLinkedList.  The fields and the DLLNode class in the
 * COMP232DoublyLinkedList class are protected fields and can be accessed
 * directly in this class.
 * 
 * @author William Goble
 * @author Dickinson College
 * 
 */
public class COMP232SortableLinkedList<E extends Comparable<E>> extends COMP232DoublyLinkedList<E> {

	/**
	 * Implementation of insertion sort for the LinkedList. The elements of the
	 * list will be sorted according to the order imposed by their compareTo
	 * method.
	 */
	public void insertionSortList() {
		// Intentionally not implemented - see homework assignment.
		// throw new UnsupportedOperationException("Not yet implemented");
		if (head.next == tail || head.next.next == tail) {
			return;
		}
		DLLNode<E> sortOver = head.next;
		while(sortOver.next != tail){
			DLLNode<E> insertNode = sortOver.next;
			if(insertNode.element.compareTo(sortOver.element)> 0){
				sortOver = sortOver.next;
			}
			else{
				sortOver.next = insertNode.next;
				insertNode.next.prev = sortOver;
				DLLNode<E> position = head.next;
				while(position != sortOver.next && insertNode.element.compareTo(position.element)>0){
					position = position.next;
				}
				insertNode.next = position;
				insertNode.prev = position.prev;
				position.prev.next = insertNode;
				position.prev = insertNode;
			}
		}
	}
}
