package Week02;

/**
 * This class creates String linked lists, you can insert new sorted items or delete items.
 * @author Tarek
 *
 */
public class LinkedList {
	
	private class Node 
	{
		String item;
		Node next;
	}
	
	/**
	 * The root of the list.
	 */
	private Node head;
	

	
	/**
	 * Creates new Linked lists and inserts items as many as the user wants.
	 * @param items is the items to insert in the list.
	 */
	public LinkedList(String... items) 
	{
		for (int i = 0; i < items.length; i++) 
		{
			this.InsertItem(items[i]);
		}
	}
	
	/**
	 * Inserts an item in the appropriate location in the list to keep it sorted.
	 * @param item is the item to be inserted in the list.
	 */
	public void InsertItem(String item) 
	{
		Node newNode; //New node holding the new item.
		
		//If the list is empty, make the new item is the head of the list.
		if(head == null) 
		{
			head = new Node();
			head.item = item;
			return;
		}
		
		
		//If the new item is less than the head, make the new item is the new head of the list.		 
		else if (head.item.compareTo(item) >= 0) 
		{
			newNode = new Node();
			newNode.next = head;
			newNode.item = item;
			head = newNode;
			
		}
		
		else 
		{
			Node runner = head.next;
			Node previous = head;
			
			while(runner != null && runner.item.compareTo(item) < 0) 
			{
				previous = runner;
				runner = runner.next;
			}
			
			newNode = new Node();
			newNode.item = item;
			newNode.next = runner;
			previous.next = newNode;
			
			return;
		}
	}
	
	/**
	 * Deletes an item from the list and keep it sorted.
	 * @param item is the item to be deleted from the list.
	 * @return true if the item was deleted successfully. false if the item wasn't delete or wasn't found in the list.
	 */
	public boolean DeleteItem(String item) 
	{
		if(head == null) 
		{
			System.out.println("There's no list"); 
			return false;
		}
		
		else if(head.item.equals(item)) 
		{
			head = head.next;
			return true;
		}
		
		else 
		{
			Node runner = head.next;
			Node previous = head;
			while(runner != null && runner.item.equals(item) == false) 
			{
				previous = runner;
				runner = runner.next;
			}
			
			if(runner != null && runner.item.equals(item) == true) 
			{
				previous.next = runner.next;
				return true;
			}
		}
		System.out.println("Item can't be found!"); 
		return false;
	}
	
	/**
	 * Prints items of the list in order.
	 */
	public void PrintItems() 
	{
		Node runner = head;
		while(runner != null) 
		{
			System.out.println(runner.item);
			runner = runner.next;
		}
		return;
	}
	
}
