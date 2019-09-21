package Logic;

    public class SinglyLinkedList<T> {
        private int size = 0;
        private Node<T> node;

        /**
         * Add element at last.
         *
         * @param data
         */
        public void add(T data) {
            if (data == null) {
                return;
            }
            if (node == null) {
                node = new Node<T>(data);
            } else {
                Node<T> newNode = new Node<T>(data);
                Node<T> lastNode = getLastNode(node);
                lastNode.setNode(newNode);
            }
            size++;
            System.out.println("Done");
        }

        /**
         * Add element at first. set the newly created node as root node
         *
         * @param data
         */
        public void addAtFirst(T data) {
            if (data == null) {
                return;
            }
            Node<T> newNode = new Node<T>(data);
            if (this.node != null) {
                newNode.setNode(this.node);
                this.node = newNode;
            } else {
                this.node = newNode;
            }
            size++;
        }

        /**
         * Add the element at specified index. Index start from 0 to n-1 where n=size of
         * linked list. If index is negative value, nothing will be added to linked
         * list.
         *
         * if index =0 , element will be added at head and element become the first
         * node.
         *
         * @param data
         * @param index
         *            - index at which element to be added.
         */
        public void add(T data, int index) throws IndexOutOfBoundsException {
            if (data == null) {
                return;
            }
            // If index=0 , we should add the data at head
            if (index == 0) {
                addAtFirst(data);
                return;
            }
            // If index= size, we should add the data at last
            if (index == this.size) {
                add(data);
            } else if (index < this.size) {
                Node<T> newNode = new Node<T>(data);
                // get the node at (index) from linked list and mark as rightNode.
                // get the node at (index-1) from linked list and mark as leftNode.
                // set node of newly created node as right node.
                // set node of left node as newly created Node.
                Node<T> leftNode = getNode(index - 1);
                Node<T> rightNode = getNode(index);
                newNode.setNode(rightNode);
                leftNode.setNode(newNode);
                size++;
            } else {
                throw new IndexOutOfBoundsException("Index not available.");
            }
        }


        private Node<T> getNode(int index) {
            if (index < 0 || index > this.size - 1) {
                throw new IndexOutOfBoundsException("Index not available.");
            }
            // If index=0 , return head
            if (index == 0) {
                return this.node;
            }
            // If index= size, return last node
            if (index == this.size - 1) {
                return getLastNode(this.node);
            }
            int pointer = 0;
            Node<T> pointerNode = this.node;
            while (pointer <= index) {
                if (pointer == index) {
                    return pointerNode;
                } else {
                    pointerNode = next(pointerNode);
                    pointer++;
                }
            }
            return null;
        }

        private Node<T> getLastNode(Node<T> node) {

            Node<T> lastNode = node;
            if (lastNode.getNode() != null) {
                return getLastNode(lastNode.getNode());
            } else {
                return lastNode;
            }
        }


        private Node<T> next(Node<T> node) {
            if (node.getNode() != null) {
                return node.getNode();
            } else {
                return null;
            }
        }

        public int size() {
            return this.size;
        }


        @Override
        public String toString() {
            String represent = "[";
            Node<T> nextNode = this.node;
            while (nextNode != null) {
                represent = represent + nextNode.toString();
                nextNode = next(nextNode);
                if (nextNode != null) {
                    represent = represent + ",";
                }
            }
            represent = represent + "]";
            return represent;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((node == null) ? 0 : node.hashCode());
            result = prime * result + size;
            return result;
        }

        /**
         * Two linked list is equal when their size is equals and both have similar node structure
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (!(obj instanceof SinglyLinkedList))
                return false;
            SinglyLinkedList other = (SinglyLinkedList) obj;
            if (node == null) {
                if (other.node != null)
                    return false;
            } else if (!node.equals(other.node))
                return false;
            if (size != other.size)
                return false;
            return true;
        }

    }
