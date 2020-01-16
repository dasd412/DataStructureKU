package week5;

public abstract class AbstractTree<E> implements Tree<E>{

	public boolean isInternal(Position<E> position) {return numChildren(position)>0;}
	public boolean isExternal(Position<E> position) {return numChildren(position)==0;}
	public boolean isRoot(Position<E> position) {return position==root();}
	public boolean isEmpty() {return size()==0;}
	public int depth(Position<E> position) {
		if(position==root()) {
			return 0;
		}
		else {
			return 1+depth(parent(position));
		}
	}
	public int height(Position<E> position) {
		int h=0;
		for(Position<E> c:children(position)) {
			h=Math.max(h, 1+height(c));
		}
		return h;
	}
	
}
