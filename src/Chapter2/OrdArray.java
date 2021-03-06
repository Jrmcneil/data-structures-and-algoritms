package Chapter2;

/**
 * OrdArray.java
 * demonstrates ordered array class
 */
public class OrdArray {
  private long[] a;
  private int nElems;

  public OrdArray(int max) {
    a = new long[max];
    nElems = 0;
  }

  public long[] getArray() {
    return a;
  }

  public int size() {
    return nElems;
  }

  public int find(long searchKey) {
    int curIn = searchHalves(nElems - 1, 0, searchKey);

    if (a[curIn] == searchKey) {
      return curIn;
    } else {
      return -1;
    }
  }

  public void insert(long value) {
    int j;

    j = searchHalves(nElems, 0, value);

    for(int k=nElems; k>j; k--) {
      a[k] = a[k - 1];
    }

    a[j] = value;

    nElems++;
  }

  private int searchHalves(int upperBound, int lowerBound, long value) {
    int position = (upperBound + lowerBound) / 2;

    if (upperBound == position) {
      return position;
    }

    if (a[position] < value) {
      return searchHalves(upperBound, position + 1, value);
    } else {
      return searchHalves(position, lowerBound, value);
    }
  }

  public boolean delete(long value) {
    int j = find(value);
    if(j == nElems) {
      return false;
    } else {
      for(int k = j; k < nElems; k++) {
        a[k] = a[k + 1];
      }

      nElems--;
      return true;
    }
  }

  public void display() {
    for(int j = 0; j < nElems; j++) {
      System.out.print(a[j] + " ");
    }

    System.out.println(" ");
  }

  public void merge(OrdArray secondArray) {
    long[] tempArray = secondArray.getArray();
    for (int j = 0; j < secondArray.size(); j++) {
      this.insert(tempArray[j]);
    }
  }
}
