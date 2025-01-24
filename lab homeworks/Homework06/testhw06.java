import static org.junit.Assert.*;
import org.junit.Test;

public class testhw06 {
    
    // Test Product class
    @Test
    public void testProduct() {
        Product product = new Mirror(4, 6);
        assertEquals("Mirror (mirror, 48.0)", product.toString());
    }
      @Test
      public void s(){

      }
    // Test Mirror class
    @Test
    public void testMirror() {
        Mirror mirror = new Mirror(4, 6);
        assertEquals(24, mirror.getArea());
        // assertEquals("reflected item: Paper", mirror.reflect(new Paper()).getNote());
    }
    
    // Test Paper class
    @Test
    public void testPaper() {
        Paper paper = new Paper();
        paper.setNote("Test note");
        assertEquals("Test note", paper.getNote());
    }
    
    // Test Matroschka class
    @Test
    public void testMatroschka() {
        Matroschka<Paper> matroschka = new Matroschka<>(new Paper());
        assertEquals("Matroschka (Doll, 5.5){Paper (Paper, 0.5)]", matroschka.toString());
    }
    
    // Test Box class
    // @Test
    // public void testBox() {
    //     Box<Paper> box = new Box<>(new Paper());
    //     assertEquals("Box {Paper (Paper, 0.5)} Seal: true", box);
    //     assertFalse(box.isSealBroken());
    // }

    // @Test
    // public void testProductConstructor() {
    //     Product product = new Product("Test Product", 10.0);
    //     assertEquals("Test Product", product.getName());
    //     assertEquals(10.0, product.getPrice(), 0.01);
    // }

    // Test Mirror class constructor
    // @Test
    // public void testMirrorConstructor() {
    //     Mirror mirror = new Mirror(4, 6);
    //     assertEquals(4, mirror.getWidth());
    //     assertEquals(6, mirror.getHeight());
    // }

    // Test Mirror class getArea() method
    @Test
