public class Hashtables {

    private StoredEmployee[] hashtable;
    //need to store key and value
    //need to take care of load factor and storage performance

    public Hashtables(){
        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee){
        int hashedkey = hashkey(key); //will give index to backing array
        if(occupied(hashedkey)){
            //set a stop index
            int stopIndex = hashedkey;
            if(hashedkey == hashtable.length - 1){//if all following slots full, loop to the front of array
                hashedkey = 0;
            }
            else{
                hashedkey++;
            }

            while (occupied(hashedkey) && hashedkey != stopIndex){
                hashedkey = (hashedkey + 1) % hashtable.length; // wrapping index back to 0
            }
        }

        if (occupied(hashedkey)){//not handling collisions
            System.out.println("Already taken " + hashedkey);
        }
        else{
            hashtable[hashedkey] = new StoredEmployee(key, employee);//if empty assign element to that position
        }
    }

    public Employee get(String key){ //getting the element at that index, need to update for linear probing, can change to constant time
        int hashedKey = findKey(key);
        if (hashedKey == -1){
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    public Employee remove(String key){//need to account for linear probing, gonna rehash table each time employee removed
        int hashedkey = findKey(key);
        if(hashedkey == -1){
            return null;
        }
        Employee employee = hashtable[hashedkey].employee;
        hashtable[hashedkey] = null;

        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];
        for(int i = 0; i < oldHashtable.length; i++){//rehasing happens here, making new keys and moving elems forward
            if(oldHashtable[i] != null){
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }


        return employee;
    }

    private int hashkey(String key) {
        return key.length() % hashtable.length;
    }//changing key (could be anything) to int

    private int findKey(String key) {
        int hashedkey = hashkey(key);
        if (hashtable[hashedkey] != null && hashtable[hashedkey].key.equals(key)) {//if key used to store employee = key passed in return that value
            return hashedkey;
        }
        //have to probe to find the key we are looking for
        int stopIndex = hashedkey;
        if (hashedkey == hashtable.length - 1) {
            hashedkey = 0;
        } else {
            hashedkey++;
        }
        while (hashedkey != stopIndex &&
                hashtable[hashedkey] != null &&
                !hashtable[hashedkey].key.equals(key)) {//need to take care of when first null is hit, loop ends
            hashedkey = (hashedkey+1) % hashtable.length;
        }
        if (hashtable[hashedkey] != null &&
                hashtable[hashedkey].key.equals(key)){
            return hashedkey;
        }
        else{
            return -1;
        }
    }

    private boolean occupied(int index){
            return hashtable[index] != null;
        }

    public void printTable(){
        for(int i = 0; i < hashtable.length; i++){
            if(hashtable[i] == null){//checking for nulls now
                System.out.println("Empty");
            }
            else {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
    }
}
