package week5;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

	public Position<E> siblings(Position<E> position){
		Position<E> parent=parent(position);
		if(parent==null) {
			return null;
		}
		else {
			if(position==left(parent)) {
				return right(parent);
			}
			else {
				return left(parent);
			}
		}
	}
	
	public int numChildren(Position<E> position) {
		int count=0;
		Position<E> leftChild=left(position);
		Position<E> rightChild=right(position);
		if(leftChild!=null) count++;
		if(rightChild!=null) count++;
		return count;
	}
	
	public Iterable<Position<E>> children(Position<E> position){
		List<Position<E>>snapShot=new ArrayList<>(2);
		if(left(position)!=null) {
			snapShot.add(left(position));
		}
		if(right(position)!=null) {
			snapShot.add(right(position));
		}
		return snapShot;
		
	}
}
