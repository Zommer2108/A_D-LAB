package de.hska.iwi.ads.solution.list;

import java.util.Map;

import de.hska.iwi.ads.dictionary.AbstractDoubleLinkedList;

public class DoubleLinkedList<K extends Comparable<K>, V> extends AbstractDoubleLinkedList<K, V> {


    /*
     *  1. public V get(Object o) gibt den Wert zur�ck, der unter dem angegebenen Schl�ssel o in der Liste ist.
     *
     *  2. Es wird null zur�ckgegeben, falls kein Wert mit diesem Schl�ssel in der Liste existiert.
     *
     *  3. Casten Sie den Parameter innerhalb Ihrer Implementierung auf den generischen Typ K.
     *
     *  4. enstandene Warnung unterdr�cken.
     */

    @SuppressWarnings("unchecked")
    public V get(Object o) { // Wert V, Schl�ssel o
        K key = (K) o;
        for (Entry<K, V> entry : entrySet()) { // Alle Werte (entry) in entrySet durchgehen
            if (entry.getKey().compareTo(key) == 0) {
                /*  Wenn der jeweilige Key unserer Werte aus entry Set, dem
                 *  eingegebenen Object/Key entspricht, dann... */

                return entry.getValue();
                // ... geben wir den Wert aus
            }
        }
        return null;
        // Null wird zur�ckgegeben, falls "kein Wert mit diesem Schl�ssel in der Liste existiert"
    }

    /*
     *  1. F�gt den Wert value am Anfang der doppelt verketteten Liste ein und gibt null zur�ck.
     *
     *  2. Falls jedoch schon ein Wert mit dem angegebenen Schl�ssel key in der Liste vorhanden ist,
     *     so wird beim zugeh�rigen ListElement-Objekt der Wert mit value �berschrieben un der alte
     *     Wert zur�ckgegeben
     */


    public V put(K key, V value) {

        if (this.size < 1) { // Wenn wir weniger als 1 Element haben
            this.head = new ListElement(new SimpleEntry<K, V>(key, value), null, null);
            /*
             * Der Verweis head zeigt auf das erste Listenelement
             */
            this.size++;
            return null;
        }
        for (Entry<K, V> entry : entrySet()) {
            if (entry.getKey().compareTo(key) == 0) {
                V ret = entry.getValue();
                entry.setValue(value);
                return ret;
            }
        }

        ListElement oldHead = this.head; // Kopie des alten Kopfes
        this.head = new ListElement(new SimpleEntry<K, V>(key, value), null, oldHead); // Neues Element wird an den Anfang der Liste gesetzt
        oldHead.previous = this.head; // Deswegen zeigt oldHead.previous auf head von davor
        this.size++; // Größe der Liste wird um 1 erhöht
        return null;

    }
}
