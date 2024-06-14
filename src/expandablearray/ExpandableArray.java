package expandablearray;

public class ExpandableArray {

    // Type Variables
    static final int TYPE_OBJECT = 0;
    static final int TYPE_STRING = 1;
    static final int TYPE_INTEGER = 2;

    // Default values
    static final int DEFAULT_LENGTH = 10;
    static final int DEFAULT_TYPE = ExpandableArray.TYPE_STRING;
    static final double DEFAULT_EXPANSION_MULTIPLIER = 2.0;

    // array variables
    int arrayLength;
    int indexPointerLocation = 1;
    int arrayType;
    String[] arrayObject;

    // Constructors
    private ExpandableArray() {
        arrayObject = new String[ExpandableArray.DEFAULT_LENGTH];

        System.out.println("Created array " + this);
    }

    private ExpandableArray(int length) {
        this.arrayLength = length;
        arrayObject = new String[this.arrayLength];

        System.out.println("Created array lengthy.. " + this);
    }


    // Basic ADD functions
    public int add(String element) {
        if (indexPointerLocation <= arrayLength) {
            arrayObject[indexPointerLocation - 1] = element;
            indexPointerLocation++;
            System.out.printf("\nElement [%s] has been added to the Array. capacity %d/%d\n-----------------------------------", element,indexPointerLocation-1, arrayLength);
            return 1;

        } else {
            arrayLength = (int) (arrayLength * DEFAULT_EXPANSION_MULTIPLIER);
            String[] newArray = new String[arrayLength];
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
    public String get(int index) {
        if (index < indexPointerLocation) {
            return arrayObject[index - 1];

        } else {
            return null;
        }
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
        ea.add("sdfasd");
        ea.add("kasun");
        ea.add("sujith");
        ea.add("kamara");

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


    }

}
