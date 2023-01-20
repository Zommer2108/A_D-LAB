package de.hska.iwi.ads.solution.tree;

import java.util.Map;
import java.util.AbstractMap.SimpleEntry;


/*
 * 1. Löschen nicht implementieren, nur Suchen und Einfügen
 * 2. Bei Comparable<K> brauchen wir nun Größenvergleiche
 *
 *
 * Notizen:
 * - Klasse Node enthält linken und rechten Verweis auf Teilbäume sowie Schlüssel-Wert-Paar als Entry-Objekt
 * - Verweis auf Wurzelknoten: protected Node root (=null)
 * - Iterator-Implementierung für entrySet()
 *
 * get:
 * - Gibt Wert zurück, wo der Schlüssel passt
 * - Gibt Null zurück, wenn kein Wert mit diesem Schlüssel existiert
 * - Casten des Parameters auf generischen Typ K
 *
 * put:
 * - Fügt Wert value in neuem Blatt ein.
 * - Falls schon ein Wert mit angegebenem Schlüssel key im Baum vorhanden, dann wird Wert mit value
 *   überschrieben und der alte Wert zurückgegeben.
 */


public class BinarySearchTree<K extends Comparable<K>, V> extends de.hska.iwi.ads.dictionary.AbstractBinaryTree<K, V> {

    public V get(Object o) {
        @SuppressWarnings("unchecked")
        K key = (K) o;
        Node y = null;
        Node x = this.root;

        // Schleife, in der der Baum durch Vergleiche und Zuweisungen "durchlaufen" wird:
        while (x != null) {
            if (x.entry.getKey().compareTo(key) == 0) { // Wenn Key von Knoten (Am Anfang Wurzel) == gesuchter key,
                // dann den value zurückgeben.
                return x.entry.getValue();
            }
            y = x;

            if (x.entry.getKey().compareTo(key) > 0) { // Key von Knoten (Am Anfang Wurzel) > gesuchter Key
                x = x.left; // also links weitersuchen
            } else {
                x = x.right; // andernfalls rechts weitersuchen
            }
        }

        if (y != null && y.entry.getKey().compareTo(key) == 0) {
            return y.entry.getValue();
        }

        return null;
    }


    /*  Falls schon ein Wert mit angegebenem Schlüssel key im Baum vorhanden, dann wird Wert mit value
     *   überschrieben und der alte Wert zurückgegeben. */
    public V put(K key, V value) {
        Node y = null;
        Node x = this.root;

        while (x != null) { // Baum wird "durchsucht" durch Vergleiche und Zuweisungen der Zeiger left und right

            // Falls einzufügender Key schon existiert, aktualisiere den alten Wert mit dem
            // neuen Wert und gib den alten Wert zurück:
            if (x.entry.getKey().compareTo(key) == 0) {
                V oldValue = x.entry.getValue();
                x.entry.setValue(value);
                return oldValue;
            }

            y = x;
            if (x.entry.getKey().compareTo(key) > 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // Blatt einfügen und Wert value darin einfügen
        Node z = new Node(key, value); // Neue Node bzw. Blatt

        if (y == null) { // Wenn Baum leer, dann wird z die Wurzel
            this.root = z;

            // Wenn der einzufügende Key
        } else if (key.compareTo(y.entry.getKey()) < 0) { // Wenn einzufügender Key < Key von Node y
            y.left = z;

        } else {
            y.right = z;
        }
        this.size++;
        return null;
    }
}
