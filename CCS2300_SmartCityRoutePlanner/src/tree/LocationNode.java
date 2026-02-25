package tree;

/*
 * LocationNode class
 * This represents a single node in the Binary Search Tree (BST).
 * Each node stores a location name and references to left and right children.
 */
public class LocationNode {

    String locationName;        // Name of the location
    LocationNode left;         // Left child
    LocationNode right;      // Right child

    // Constructor to initialize node with location name
    public LocationNode(String locationName) {
        this.locationName = locationName;
        this.left = null;
        this.right = null;
    }
}