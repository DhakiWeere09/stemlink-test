package expandablearray;

public class ExpandableArray {

    // Default values
    static final int DEFAULT_LENGTH = 10;
    static final double DEFAULT_EXPANSION_MULTIPLIER = 1.5;

    // array variables
    int arrayLength;
    int indexPointerLocation = 1;
    Object[] arrayObject;

    // Constructors
    public ExpandableArray() {
        arrayObject = new String[ExpandableArray.DEFAULT_LENGTH];

        System.out.println("Created array " + this);
    }

    public ExpandableArray(int length) {
        this.arrayLength = length;
        arrayObject = new Object[this.arrayLength];

        System.out.println("Created array lengthy.. " + this);
    }


    // Basic ADD functions
    public int add(Object element) {
        if (indexPointerLocation <= arrayLength) {

            arrayObject[indexPointerLocation - 1] = element.toString();
            indexPointerLocation++;
            System.out.printf("\nElement [%s] has been added to the Array. capacity %d/%d\n-----------------------------------\n", element,indexPointerLocation-1, arrayLength);
            return 1;

        } else {
            arrayLength = (int) (arrayLength * DEFAULT_EXPANSION_MULTIPLIER);
            Object[] newArray = new Object[arrayLength];
            for (int i = 0; i < arrayObject.length; i++) {
                newArray[i] = arrayObject[i];
            }

            newArray[indexPointerLocation - 1] = element;
            arrayObject = newArray;
            indexPointerLocation++;
            System.out.printf("Array has been expanded. New max capacity : %d.\nElement [%s] has been added to the Array. capacity %d/%d\n", arrayLength, element,indexPointerLocation-1, arrayLength);
            return 11;

        }


    }

    // Basic GET method
    public Object get(int index) {
        if (index < indexPointerLocation) {
            return arrayObject[index - 1];

        } else {
            return null;
        }
    }

    // Basic REMOVE method
    public void remove(int index){
        Object remElement = arrayObject[index-1];
        for (int i = index; i < indexPointerLocation; i++) {
            arrayObject[i-1] = arrayObject[i];
        }
        indexPointerLocation--;

        System.out.printf("\nElement [%s] at index (%d) has been removed from the Array. capacity %d/%d\n-----------------------------------\n",
                remElement.toString(), index, indexPointerLocation-1, arrayLength);
    }

    //Basic SHOW method
    public void showElements() {
        System.out.println("------------------------------------");
        for (int i = 0; i < arrayObject.length; i++) {
            System.out.printf("%d : %s\n", i + 1, arrayObject[i]);
        }
        System.out.println("-------------------------------------\n\n");
    }

    public static void main(String[] args) {
        ExpandableArray ea = new ExpandableArray(5);
        ea.add("dhanika");
        ea.add(2);
        ea.add("kasun");
        ea.add(true);
        ea.add(4.5);

        ea.showElements();

        ea.add("the sixth man");

        ea.showElements();

        ea.add("the 7");
        ea.add("8th thing");
        ea.add("9 element");
        ea.add("10th element");

        ea.showElements();

        ea.add("the magic 11th");

        ea.showElements();

        System.out.println(ea.get(7));

        ea.remove(6);

        ea.showElements();

        ea.add(11.11);

        ea.showElements();


    }

}
