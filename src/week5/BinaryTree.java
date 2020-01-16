package week5;

public interface BinaryTree<E> extends Tree<E> {

	Position<E> left(Position<E> position)throws IllegalArgumentException;
	Position<E> right(Position<E> position)throws IllegalArgumentException;
	Position<E> siblings(Position<E> position)throws IllegalArgumentException;
}
