# ArrayList dan Hashtable

## ArrayList
ArrayList merupakan sebuah struktur data yang mirip dengan array (yang telah dipelajari di Pemrograman Dasar I). Perbedaannya adalah, kita dapat menambahkan data baru secara dinamis tanpa harus menentukan ukurannya di awal. Operasi yang dilakukan terhadap ArrayList lebih banyak dan lebih mudah dibandingkan dengan array biasa. Berbagai operasi yang dapat dilakukan terhadap ArrayList adalah seperti berikut:
* **size()**, untuk mencari panjang ArrayList
* **add()**, untuk menambah elemen baru
* **get()**, untuk mengambil elemen pada indeks tertentu
* **isEmpty()**, untuk memeriksa apakah ArrayList kosong atau tidak
* **indexOf()**, untuk mengetahui indeks dari suatu nilai
* **contains()**, untuk memeriksa apakah suatu nilai ada dalam ArrayList
* **set()**, untuk menimpa nilai pada indeks tertentu
* **remove()**, untuk menghapus nilai pada indeks tertentu

## HashTable
HashTable adalah *collection* berbasis hash yang ada di Java untuk memetakan objek dalam bentuk pasangan *key-value* (kunci-nilai).
Ciri-ciri HashTable :
* *Collection* yang bersifat *thread-safe*. Artinya jika *resource* HashTable digunakan dalam waktu bersamaan, dapat dipastikan data yang ada akan selalu memiliki hasil yang sama (tersinkronisasi).
* Lebih lambat karena Hashtable tersinkronisasi.
* Hashtable merupakan kelas yang *obsolete* (sudah tidak disarankan penggunaannya). Jika ingin menggunakan Hashtable, disarankan untuk menggunakan ConcurrentHashMap

## Contoh Program
### ArrayList
```
import java.util.ArrayList;

class DemoArrayList { 
    public static void main (String[] args){
        ArrayList<Integer> deret = new ArrayList<Integer>();

        System.out.println("Panjang deret awal: "+deret.size());

        for (int i = 0; i < 10; i++){
            deret.add(i * 10);
        }

        System.out.println("\nPanjang deret setelah ditambah elemen: "+deret.size());

        for (int i = 0; i < deret.size(); i++){
            System.out.println("elemen ke - " + i + " : " + deret.get(i));
        }

        System.out.println("\nMemeriksa apakah array list kosong: ");
        System.out.println(deret.isEmpty());    

        System.out.println("\nMencari indeks dari suatu nilai di dalam array list: ");
        System.out.println(deret.indexOf(60));  
        System.out.println(deret.indexOf(70));  
        System.out.println(deret.indexOf(80));  

        System.out.println("\nMemeriksa keberadaan suatu nilai di dalam array list: ");
        System.out.println(deret.contains(60)); 
        System.out.println(deret.contains(70)); 
        System.out.println(deret.contains(80)); 

        System.out.println("\nUpdate suatu nilai di dalam array list: ");
        deret.set(6, 600);  
        deret.set(7, 700);  
        deret.set(8, 800);  

        System.out.println(deret.get(6));   
        System.out.println(deret.get(7));   
        System.out.println(deret.get(8));   

        System.out.println("\nMenghapus suatu nilai di dalam array list: ");
        deret.remove(6);    
        deret.remove(6);    
        deret.remove(6);    

        System.out.println("\nPanjang deret setelah menghapus beberapa elemen: "+deret.size());

        for (int i = 0; i < deret.size(); i++){
            System.out.println("elemen ke - " + i + " : " + deret.get(i));
        }
    }
}
```
### Hashtable
```
import java.util.Hashtable;
import java.util.Map;

public class ContohHashTable {
    public static void main(String[] args) {
        // Deklarasi objek Hashtable baru
        Hashtable<String, Double> nilai = new Hashtable<String, Double>();

        // Menambahkan data ke objek
        nilai.put("Andi", 85.2);
        nilai.put("Budi", 100.0);
        nilai.put("Edi", 88.5);
        nilai.put("Fera", 87.20);

        // Mengakses data Hashtable dengan foreach
        for (Map.Entry hasil : nilai.entrySet()){
            System.out.println(hasil.getKey() + " : " + hasil.getValue());
        }
    }
}
```

**Sumber :** CodePolitan, dengan perubahan seperlunya. (Klik pada link di bawah ini)

* [Perbedaan Hashtable dan HashMap di Java](https://www.codepolitan.com/perbedaan-perbedaan-hashtable-dan-hashmap-java)
* [Menggunakan ArrayList di Java](https://www.codepolitan.com/menggunakan-arraylist-di-java)