package de.hska.iwi.ads.solution.hashtable;


import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

import de.hska.iwi.ads.dictionary.AbstractHashMap;

/*
 *  1. Quadratisches Sondieren: h(k,i) = (h'(k)+i^2) mod m
 *  2. Geschlossene Behälter: Behälter hat nur einen oder konstant viele Schlüssel
 *  3. Größe m der Tabelle im Konstruktoraufruf festgelegt und danach nicht mehr veränderbar
 *  4. Exception, falls beim Einfügen kein Platz mehr gefunden wurde
 *
 *  Notizen:
 * - Entries<K,V> sind Schlüssel-Wert Paare
 * - Zwei Methoden: get und put
 *
 * get:
 * - Gibt Wert von Schlüssel o (Eingabeparameter) zurück.
 * - Gibt Null zurück, wenn kein Wert mit Schlüssel o existiert.
 * - Parameter auf generischen Typ K casten.
 *
 * put:
 * - Fügt Wert value in einen leeren Behälter in der Hashtabelle ein.
 * - Falls ein Wert mit Schlüssel key in Tabelle bereits vorhanden -> Wert in Behälter mit value überschrieben
 *   und alter Wert zurückgegeben.
 */


public class Hashtable<K extends Comparable<K>, V> extends AbstractHashMap<K, V> {

    int m; //Größe

    public Hashtable(int capacity) { //Konstruktor
        super(capacity);
        m = capacity;
    }


    @SuppressWarnings("unchecked") // Sonst meckert er wegen dem Cast
    public V get(Object o) {
        K key = (K) o; // Parameter auf generischen Typ casten


        int s;
        int i = 0;
        do {
            s = sondieren(key, i);
            if (this.hashtable[s] != null && this.hashtable[s].getKey().compareTo(key) == 0) {
                return this.hashtable[s].getValue(); // Gibt Wert value von Schlüssel o zurück.
            }
        } while ((this.hashtable[s] != null && i < m));
        return null; // Wenn Wert von Schl�ssel o nicht existiert

    }

    public int sondieren(K key, int i) {
        int k = key.hashCode();
        return ((k % m) + (i * i)) % m; // Quadratisches Sondieren
    }

    /*
     * * put:
     * - Fügt Wert value in einen leeren Behälter in der Hashtabelle ein.
     * - Falls ein Wert mit Schlüssel key in Tabelle bereits vorhanden -> Wert in Behälter mit value überschrieben
     *   und alter Wert zurückgegeben.
     */

    public V put(K key, V value) {

        if (this.get(key) != null) {
            for (Entry<K, V> SchluesselWertPaar : this.hashtable) {
                // Alle Schlüssel-Wert-Paare der Hashtabelle durchgehen


                if (SchluesselWertPaar != null && SchluesselWertPaar.getKey().compareTo(key) == 0) {
                    // Wenn gesuchter key (aus Parametern) mit einem der Keys der Paare der Hashtabelle übereinstimmt...

                    V oldValue =
                        SchluesselWertPaar.getValue(); // Aktueller Wert in Tabelle wird in oldValue gespeichert
                    SchluesselWertPaar.setValue(
                        value); // Der gewünschte Value (aus Parameter) wird der neue Wert des Paares in der Hashtabelle.
                    return oldValue; // Alter Wert zurückgegeben, warum? ka
                }
            }
        } // Ende des If-Blocks (Zeile 81)

        // Ansonsten, falls der der key noch nicht vorhanden ist, muss man den Value in einen
        // leeren Behälter einfügen. Dazu müssen wir (quadratisch) sondieren:

        int i = 0;
        int s;
        do {
            s = sondieren(key, i); // s ist Wert für Behälter in Hashtabelle
            if (this.hashtable[s] == null) { // "Wenn Behälter frei"
                this.hashtable[s] = new SimpleEntry<K, V>(key, value); // Neuer Eintrag eines K-V-Paares mit key = key aus Parametern
                this.hashtable[s].setValue(value); // value = value aus Parametern
                this.size++; // "The number of key-value mappings in this Map"
                return value;
            }
            i++;
        }
        while (i < m); // Macht natürlich keinen Sinn, öfter zu sondieren als die Hashtabelle groß ist...

        throw new DictionaryFullException(); // Falls bis hier noch immer kein return, dann wurde
        //										kein freier Platz gefunden

    }

}
