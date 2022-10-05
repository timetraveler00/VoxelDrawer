import java.applet.Applet;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.Sphere;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Behavior;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.WakeupOnAWTEvent;

import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.Color; 
import java.awt.Panel; 
import java.awt.LayoutManager;
import java.awt.BorderLayout; 
import java.awt.GraphicsConfiguration;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;


public class BouncingBall extends Applet implements ActionListener, KeyListener { 
    private Button go = new Button("Go");
    private TransformGroup objTrans;
    private Transform3D trans = new Transform3D();
    private float height=0.0f; 
    private float sign = 1.0f; // going up or down
    private Timer timer;
    private float xloc=0.0f;
    
    /**
     * The SimpleUniverse object
     */
    protected SimpleUniverse simpleU;
  

    /**
     * The root BranchGroup Object.
     */
  //  protected BranchGroup rootBranchGroup;

    
    public BranchGroup createSceneGraph() {

    	
    	 // Set up colors
        Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
        Color3f white = new Color3f(1.0f, 1.0f, 1.0f);
        Color3f red = new Color3f(0.7f, .15f, .15f);
    	
        /*
    	 // Set up the texture map
        TextureLoader loader = new TextureLoader("d:\\savaslinkedin.jpg",                
                                  "LUMINANCE", new Container());
        Texture texture = loader.getTexture();
        texture.setBoundaryModeS(Texture.LUMINANCE_ALPHA);
        texture.setBoundaryModeT(Texture.ALPHA);
        texture.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
    	
        // Set up the texture attributes 
        //could be REPLACE, BLEND or DECAL instead of MODULATE
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);
        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);
     	
        //set up the material
        ap.setMaterial(new Material(red, black, red, black, 1.0f));
        int primflags = Primitive.GENERATE_NORMALS +                     
                Primitive.GENERATE_TEXTURE_COORDS; 
    	*/
    	// Create the root of the branch graph
	BranchGroup objRoot = new BranchGroup();
	objTrans = new TransformGroup();
	objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	objRoot.addChild(objTrans);
/*
	// Create a simple shape leaf node, add it to the scene graph.
    Sphere sphere = new Sphere(0.25f,primflags, ap);
    
    */
    objTrans = new TransformGroup();
    objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    Transform3D pos1 = new Transform3D();    
    pos1.setTranslation(new Vector3f(0.0f,0.0f,0.0f));
    objTrans.setTransform(pos1);
   // objTrans.addChild(sphere);
    objRoot.addChild(objTrans);
        BoundingSphere bounds =
	    new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);


    Color3f light1Color = new Color3f(2.0f, 0.0f, 0.2f);
    Vector3f light1Direction  = new Vector3f(8.0f, -7.0f, -8.0f);
    DirectionalLight light1
      = new DirectionalLight(light1Color, light1Direction);
    light1.setInfluencingBounds(bounds);
    objRoot.addChild(light1);

     // Set up the ambient light
    Color3f ambientColor = new Color3f(4.0f, 1.0f, 6.0f);
    AmbientLight ambientLightNode = new AmbientLight(ambientColor);
    ambientLightNode.setInfluencingBounds(bounds);
    objRoot.addChild(ambientLightNode);

    	return objRoot;
    }

    public BouncingBall() {
	    setLayout(new BorderLayout());
        GraphicsConfiguration config =
            SimpleUniverse.getPreferredConfiguration();
        Canvas3D c = new Canvas3D(config);
	    add("Center", c);
        c.addKeyListener(this);
        //timer = new Timer(200,this);
        //timer.start();
	    Panel p =new Panel();
	    p.add(go);
	    add("North",p);
	    go.addActionListener(this);
	    go.addKeyListener(this);
	    // Create a simple scene and attach it to the virtual universe
	    
	    //BranchGroup scene = createSceneGraph();
	    
	  /*  Vector3f vector = new Vector3f(-0.3f, 0.0f, 0.0f); 
	    Transform3D transform = new Transform3D(); 
	    transform.setTranslation(vector); 
	    TransformGroup transformGroup = new TransformGroup(transform);
	    transformGroup.addChild(createSceneGraph5());
	    
	    Vector3f vector2 = new Vector3f(0.2f, -0.3f, -0.2f); 
	    Transform3D transform2 = new Transform3D(); 
	    transform2.setTranslation(vector2); 
	    TransformGroup transformGroup2 = new TransformGroup(transform2);
	    transformGroup2.addChild(createSceneGraph5a());
	    */
	    Vector3f vector3 = new Vector3f(0.0f, 0.0f, 0.0f); 
	    Transform3D transform3 = new Transform3D(); 
	    transform3.setTranslation(vector3); 
	    TransformGroup transformGroup3 = new TransformGroup(transform3);
	  //  transformGroup3.addChild(createSceneGraph5b());
	    
	   /* Cone sphere = new Cone(0.1f);
        TransformGroup tg = new TransformGroup();
        Transform3D transform4 = new Transform3D();
        Vector3f vector4 = new Vector3f( 0.6f, 0.6f, 0.1f);
        transform4.setTranslation(vector4);
        tg.setTransform(transform4);
        tg.addChild(sphere);
        */
	    
	    //// BranchGroup scene3 = createSceneGraph3();
	    //BranchGroup scene5 = createSceneGraph5();

	    // BranchGroup scene5a = createSceneGraph5a();
	   // scene.addChild(transformGroup);
	   // scene.addChild(transformGroup2);
	    //scene.addChild(transformGroup3);
	   // scene.addChild(tg);
	    
	    
	    SimpleUniverse u = new SimpleUniverse(c);
        u.getViewingPlatform().setNominalViewingTransform();
        
        u.addBranchGraph(createSceneGraph5b());
	    //u.addBranchGraph(scene);
	    //u.addBranchGraph(scene3);
	//    u.addBranchGraph(scene5);
	//    u.addBranchGraph(scene5a);
    }
    public void keyPressed(KeyEvent e) {
        //Invoked when a key has been pressed.     
        if (e.getKeyChar()=='s') {xloc = xloc + .1f;}
        if (e.getKeyChar()=='a') {xloc = xloc - .1f;}
    }

    public void keyReleased(KeyEvent e){
        // Invoked when a key has been released.
    }
    public void keyTyped(KeyEvent e){
        //Invoked when a key has been typed.
    }
    public void actionPerformed(ActionEvent e ) {
        // start timer when button is pressed
	    if (e.getSource()==go){
	       /* if (!timer.isRunning()) {
	            timer.start();
            }*/
        }
        else {
	        height += .1 * sign;
        if (Math.abs(height *2)  >= 1 ) sign = -1.0f * sign;
        if (height<-0.4f) {
            trans.setScale(new Vector3d(1.0, .6, 1.0));
        }  
        else {
            trans.setScale(new Vector3d(1.0, 1.0, 1.0));
        }
        trans.setTranslation(new Vector3f(xloc,height,0.0f));
	        objTrans.setTransform(trans);
	    }
    }
    public static void main(String[] args) {
        System.out.println("Program Started");
        BouncingBall bb = new BouncingBall();
        bb.addKeyListener(bb);
	    MainFrame mf = new MainFrame(bb, 256, 256);	
    }
    
  /*  public BranchGroup createSceneGraph2() {
        BranchGroup objRoot = new BranchGroup();
     
        TransformGroup objRotate = new TransformGroup();
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
     
        objRoot.addChild(objRotate);
        objRotate.addChild(new ColorCube(0.4));
     
        MouseRotate myMouseRotate = new MouseRotate();
        myMouseRotate.setTransformGroup(objRotate);
        myMouseRotate.setSchedulingBounds(new BoundingSphere());
        objRoot.addChild(myMouseRotate);
     
        objRoot.compile();
     
        return objRoot;
    }*/
    
/*   public BranchGroup createSceneGraph4(SimpleUniverse su) {
    	// Create the root of the branch graph
    	TransformGroup vpTrans = null;
    	Vector3f translate = new Vector3f();
    	Transform3D T3D = new Transform3D();
    	BranchGroup objRoot = new BranchGroup();
    	objRoot.addChild(createLand()); // create other content
    	vpTrans = su.getViewingPlatform().getViewPlatformTransform();
    	translate.set( 0.0f, 0.3f, 0.0f); // 3 meter elevation
    	T3D.setTranslation(translate); // set as translation
    	vpTrans.setTransform(T3D); // used for initial position
    	KeyNavigatorBehavior keyNavBeh =
    	new KeyNavigatorBehavior(vpTrans);
    	keyNavBeh.setSchedulingBounds(new BoundingSphere(
    	new Point3d(),1000.0));
    	objRoot.addChild(keyNavBeh);
    	objRoot.compile();
    	return objRoot;
    	} // end 
  */  
    public BranchGroup createSceneGraph5() {
    	// Create the root of the branch graph
    	BranchGroup objRoot = new BranchGroup();
    
    	TransformGroup objRotate = new TransformGroup();
    	objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    	objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    
    	
    	objRoot.addChild(objRotate);
    	objRotate.addChild(new ColorCube(0.2));
    	
    
    	MouseRotate myMouseRotate = new MouseRotate();
    	myMouseRotate.setTransformGroup(objRotate);
    	
  
    	BoundingSphere bounds = new BoundingSphere(new Point3d(20.0,40.0,70.0),50); 
    	
    	myMouseRotate.setSchedulingBounds(new BoundingSphere());
    	
    	
    	objRoot.addChild(myMouseRotate);
    
    	
    	objRoot.compile();
    
    	return objRoot;
    	} 

    public BranchGroup createSceneGraph5a() {
    	// Create the root of the branch graph
    	
    	BranchGroup objRoot2 = new BranchGroup();
    	
 
    	TransformGroup objRotate2 = new TransformGroup();
    	objRotate2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    	objRotate2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    	
   
    	objRoot2.addChild(objRotate2);
    	objRotate2.addChild(new ColorCube(0.1));
    	
   
    	MouseRotate myMouseRotate2 = new MouseRotate();
    	myMouseRotate2.setTransformGroup(objRotate2);
    	
    	BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),1); 
    	
    	
    	myMouseRotate2.setSchedulingBounds(bounds/*new BoundingSphere()*/);
    	
    
    	objRoot2.addChild(myMouseRotate2);
    
    	objRoot2.compile();
    	return objRoot2;
    	}
    
    
    
    // Working version 
    public BranchGroup createSceneGraph5b() {
    	// Create the root of the branch graph
    	
    	BranchGroup objRoot2 = new BranchGroup();
    	
 
    	TransformGroup objRotate2 = new TransformGroup();
    	objRotate2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    	objRotate2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    	
   
    	objRoot2.addChild(objRotate2);
    	//objRotate2.addChild(new ColorCube(0.1));
    	
    	
    	/*
    	Vector3f vector3 = new Vector3f(-0.1f, 0.0f, 0.0f); 
	    Transform3D transform3 = new Transform3D(); 
	    transform3.setTranslation(vector3); 
	    TransformGroup transformGroup3 = new TransformGroup(transform3);
	    transformGroup3.addChild(new ColorCube(0.05));
	    
    	objRotate2.addChild(transformGroup3);
    	
    	Vector3f vector4 = new Vector3f(0.0f, 0.0f, 0.0f); 
	    Transform3D transform4 = new Transform3D(); 
	    transform4.setTranslation(vector4); 
	    TransformGroup transformGroup4 = new TransformGroup(transform4);
	    transformGroup4.addChild(new ColorCube(0.05));
	    
    	objRotate2.addChild(transformGroup4);
    	
    	Vector3f vector5 = new Vector3f(0.4f, 0.0f, 0.0f); 
	    Transform3D transform5 = new Transform3D(); 
	    transform5.setTranslation(vector5); 
	    TransformGroup transformGroup5 = new TransformGroup(transform5);
	    transformGroup5.addChild(new ColorCube(0.05));
	    
    	objRotate2.addChild(transformGroup5);
    	
    	Vector3f vector6 = new Vector3f(0.5f, 0.0f, 0.0f); 
	    Transform3D transform6 = new Transform3D(); 
	    transform6.setTranslation(vector6); 
	    TransformGroup transformGroup6 = new TransformGroup(transform6);
	    transformGroup6.addChild(new ColorCube(0.05));
	    
    	objRotate2.addChild(transformGroup6);
    	
    	Vector3f vector7 = new Vector3f(0.5f, 0.0f, 0.0f); 
	    Transform3D transform7 = new Transform3D(); 
	    transform7.setTranslation(vector7); 
	    transform7.setScale(0.5);
	    TransformGroup transformGroup7 = new TransformGroup(transform7);
	  	    transformGroup7.addChild(addBox(0.5f, 0.1f, 0.1f, new Color3f(1, 1, 0), new Color3f(1, 0, 1)));
	    
    	objRotate2.addChild(transformGroup7);
    	*/
    	    
    	
    	Excel excel = new Excel();
    	ShipStructure ship = excel.ReadShip(); 
    	float shrinkc = 1f;
    	float shrink = shrinkc*shrinkc;
    			
    	//hip.data = makeDamage(19, 14, 2, ship , 30);
    	//ship.data = makeDamage(16, 18, 3, ship , 40);
    	//ship.data = makeDamage(3, 8, 4, ship , 98);
    	//ship.data = makeDamage(28, 6, 2, ship , 98);
    	//ship.data = makeDamage(14, 8, 0, ship , 98);
    	
    	//colorImage = makeDamage (9,5,5,colorImage,77);
    	//colorImage = makeDamage (3,6,4,colorImage,44); 
    	/*try {
			excel.ReadXLSX();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	*/
    	String textureName="";
    	
    	float xscaleFactor = 0.1f; /// (float)ship.length;
    	float yscaleFactor = 0.1f; // / (float)ship.height;
    	float zscaleFactor = 0.1f; //  / (float)ship.width;
    	System.out.println("xscaleFactor:  " + xscaleFactor);
    	System.out.println("yscaleFactor:  " + yscaleFactor);
    	System.out.println("zscaleFactor:  " + zscaleFactor);
    	System.out.println("length  " + ship.length);
    	System.out.println("WÝDTH  " + ship.width);
    	System.out.println("heýght  " + ship.height);
    	
    	float q = 50.0f; 
    	
    	for (int i=0; i<ship.length;i++) 
    	{
    		// float x= (i * xscaleFactor -  (float)ship.length/q)*shrink; 
    		float x= (i * xscaleFactor -  (float)ship.length/q)*shrink; 
    		for (int j=0; j<ship.height;j++) 
        	{
        		float y= (j * yscaleFactor - (float)ship.height/q)*shrink; 
    		
    			for (int k=0; k<ship.width;k++) 
            	{
            		float z= (k * zscaleFactor - (float)ship.width/q)*shrink;
            		int cellValue = ship.data[i][j][k]; //colorImage[i][j][k];
            		
            		int ired = cellValue / 1000000;
            		cellValue = cellValue-ired * 1000000; 
            		int igreen = cellValue / 1000; 
            		int iblue  = cellValue - igreen * 1000; 
            		
            		
            		float b = iblue / 256.0f; 
            		float g = igreen / 256.0f; 
            		float r = ired / 256.0f;  
            		Color3f cc = new Color3f(r, g, b); 
            		
            		/*if (cellValue>0) { 
            		
            		if (cellValue==1) 
            		{
            			
            			textureName= "d:\\Textures\\undamagedbody.jpg";
            		}
            		else if (cellValue>1) 
            		{
            			textureName = "d:\\Textures\\"+((ship.data[i][j][k])/10)*10  +".jpg";
            			
            		}*/
            		//System.out.println(i+" "+j+" "+k + "   :" +textureName + "  " + cellValue);
            		//System.out.println(x+" "+y+" "+z );
            			
            		Vector3f vector7 = new Vector3f(x, y, z); 
            		Transform3D transform7 = new Transform3D(); 
            		transform7.setTranslation(vector7); 
            		
            		transform7.setScale(0.5*shrinkc);
            		TransformGroup transformGroup7 = new TransformGroup(transform7);
            		if (cellValue != 0)
            		    transformGroup7.addChild(addBox_Color(0.1f*shrinkc, 0.1f*shrinkc, 0.1f*shrinkc, new Color3f(1,200, 1), new Color3f(1, 250, 1),cc));
            	//	transformGroup7.addChild(addBox_Color(0.1f*shrinkc, 0.1f*shrinkc, 0.1f*shrinkc, new Color3f(1,200, 1), new Color3f(1, 250, 1),new Color3f(1, 250, 1)));
            		
            		objRotate2.addChild(transformGroup7);		
            		
            		
            	} // z
    			
        	} // y
    		
    	}
    	
    	
    	
   
    	MouseRotate myMouseRotate2 = new MouseRotate();
    	myMouseRotate2.setTransformGroup(objRotate2);
    	
    	BoundingSphere bounds = new BoundingSphere(new Point3d(0.0f,0.0f,0.0f),100); 
    	
    	
    	myMouseRotate2.setSchedulingBounds(bounds/*new BoundingSphere()*/);
    	
    
    	objRoot2.addChild(myMouseRotate2);
    
    	objRoot2.compile();
    	return objRoot2;
    	} 
    
    public Color GetAlphaColor(double alpha) 
	{
		Color c = null; 
		
		double blue = 0; 
		double red = 0; 
		double green = 0; 
		double value= alpha; 
	//	double spread = maxxx-minnn;
		
		
		    
		    double ratio = 2 * (value-1) / (99);
		    blue = (Math.max(0, 255*(1 - ratio)));
		    red = (Math.max(0, 255*(ratio - 1)));
		    green = 255 - blue - red;
		    c = new Color ((int)red, (int)green, (int)blue) ; 
		    return c; 
	         	
		}
    
    public int[][][] makeDamage (int xx, int yy, int zz, ShipStructure ss, int damage) 
    {
    	int ship [][][] = ss.data; 
    	
    	   	
    	for (int i=0; i<ss.length;i++) 
    	{

    		for (int j=0; j<ss.height;j++) 
        	{

    		
    			for (int k=0; k<ss.width;k++) 
            	{
    				
    				if (ship [i][j][k]>0) 
    				{
    				   
    					double a= Math.abs(xx-i);  
    					double b= Math.abs(zz-k);
    					double c= Math.abs(yy-j);
    					
    					double ekare = a*a + b*b + c*c;
    					   					
    					double dist = Math.sqrt (ekare);
    				   
    					double calcDamage = damage-dist*30;
    					calcDamage = calcDamage>0?calcDamage:0;
    					int instantDamage = (int) (ship[i][j][k] + calcDamage);
    					instantDamage = instantDamage>99?99:instantDamage;
    					System.out.println("i: " + i + " j: "+ j + " k: "+k + " calcDamage: "+calcDamage + "instantDamage: "+instantDamage + " ss: "+ss.data[i][j][k]);
    					
    					if ( instantDamage > 1) 
    						ship [i][j][k] = instantDamage;
    				   
    				}
            	}
    			
        	}
    	}
    	
    	
    	
    	
    	
    	return ship;  
    }

    public BranchGroup addBox_Color(float x, float y, float z, Color3f diffuse, Color3f spec , Color3f cellColor) {
        // Add a box with the given dimension
BranchGroup rootBranchGroup = new BranchGroup();
        // First setup an appearance for the box
        Appearance app = new Appearance();
        Material mat = new Material();
        mat.setDiffuseColor(diffuse);
        mat.setSpecularColor(spec);
        mat.setShininess(5.0f);
        mat.setAmbientColor(1f, 1f, 1f);
        mat.setDiffuseColor(1f, 1f, 1f);

        Color3f col = cellColor;
        ColoringAttributes ca = new ColoringAttributes (col, ColoringAttributes.NICEST);
        app.setColoringAttributes(ca);
        
        
        app.setMaterial(mat);
        Box box = new Box(x, y, z, app);
        
        
        
        ////////////////////////////////////////////////
        
        TextureLoader loader;
        Texture texture; 

        Box caja=new Box(x,y,z,Box.GENERATE_TEXTURE_COORDS,new Appearance());
        Appearance ap = new Appearance();
        //ap.setMaterial(mat);
       // loader = new TextureLoader(textureFile,this);
     //   texture = loader.getTexture();
      //  ap.setTexture(texture);
         //  caja.setAppearance(app);
        caja.setAppearance(Box.BACK,app);
        caja.setAppearance(Box.TOP,app);
        caja.setAppearance(Box.BOTTOM,app);
        caja.setAppearance(Box.LEFT,app);
        caja.setAppearance(Box.RIGHT,app);
        caja.setAppearance(Box.FRONT,app);
     
       

       /* loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap.setTexture(texture);
        caja.setAppearance(Box.BACK,ap);

        Appearance ap2 = new Appearance();

        loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap2.setTexture(texture);
        caja.setAppearance(Box.TOP,ap2);

        Appearance ap3 = new Appearance();

        loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap3.setTexture(texture);
        caja.setAppearance(Box.BOTTOM,ap3);

        Appearance ap4 = new Appearance();

        loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap4.setTexture(texture);
        caja.setAppearance(Box.LEFT,ap4);

        Appearance ap5 = new Appearance();

        loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap5.setTexture(texture);
        caja.setAppearance(Box.RIGHT,ap5);

         Appearance ap6 = new Appearance();

        loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap6.setTexture(texture);
        caja.setAppearance(Box.FRONT,ap6);

    */
        
        
        /////////////////////////////////////////////////
        

        // Create a TransformGroup and make it the parent of the box
        TransformGroup tg = new TransformGroup();
     //   tg.addChild(box);
        tg.addChild(caja);

        // Then add it to the rootBranchGroup
        rootBranchGroup.addChild(tg);

        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

      /*  MouseRotate myMouseRotate = new MouseRotate();
        myMouseRotate.setTransformGroup(tg);
        myMouseRotate.setSchedulingBounds(new BoundingSphere());
        rootBranchGroup.addChild(myMouseRotate);

        MouseTranslate myMouseTranslate = new MouseTranslate();
        myMouseTranslate.setTransformGroup(tg);
        myMouseTranslate.setSchedulingBounds(new BoundingSphere());
        rootBranchGroup.addChild(myMouseTranslate);

        MouseZoom myMouseZoom = new MouseZoom();
        myMouseZoom.setTransformGroup(tg);
        myMouseZoom.setSchedulingBounds(new BoundingSphere());
        rootBranchGroup.addChild(myMouseZoom);*/
        
        return rootBranchGroup;
      }
    
    
    
    // Texture 
    public BranchGroup addBox(float x, float y, float z, Color3f diffuse, Color3f spec ,String textureFile) {
        // Add a box with the given dimension
BranchGroup rootBranchGroup = new BranchGroup();
        // First setup an appearance for the box
        Appearance app = new Appearance();
        Material mat = new Material();
        mat.setDiffuseColor(diffuse);
        mat.setSpecularColor(spec);
        mat.setShininess(5.0f);
        mat.setAmbientColor(0.1f, 0.8f, 0.1f);
        mat.setDiffuseColor(0.1f, 0.8f, 0.1f);

        Color3f col = new Color3f(0.7f, 0.3f, 1.0f);
        ColoringAttributes ca = new ColoringAttributes (col, ColoringAttributes.NICEST);
        app.setColoringAttributes(ca);
        
        
        app.setMaterial(mat);
        
        Box box = new Box(x, y, z, app);
        
        
        
        ////////////////////////////////////////////////
        
        TextureLoader loader;
        Texture texture; 

        Box caja=new Box(x,y,z,Box.GENERATE_TEXTURE_COORDS,new Appearance());
        Appearance ap = new Appearance();
        //ap.setMaterial(mat);
        loader = new TextureLoader(textureFile,this);
        texture = loader.getTexture();
        ap.setTexture(texture);
        caja.setAppearance(ap);
       

       /* loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap.setTexture(texture);
        caja.setAppearance(Box.BACK,ap);

        Appearance ap2 = new Appearance();

        loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap2.setTexture(texture);
        caja.setAppearance(Box.TOP,ap2);

        Appearance ap3 = new Appearance();

        loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap3.setTexture(texture);
        caja.setAppearance(Box.BOTTOM,ap3);

        Appearance ap4 = new Appearance();

        loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap4.setTexture(texture);
        caja.setAppearance(Box.LEFT,ap4);

        Appearance ap5 = new Appearance();

        loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap5.setTexture(texture);
        caja.setAppearance(Box.RIGHT,ap5);

         Appearance ap6 = new Appearance();

        loader = new TextureLoader("d:\\white.jpg",this);
        texture = loader.getTexture();
        ap6.setTexture(texture);
        caja.setAppearance(Box.FRONT,ap6);

    */
        
        
        /////////////////////////////////////////////////
        

        // Create a TransformGroup and make it the parent of the box
        TransformGroup tg = new TransformGroup();
     //   tg.addChild(box);
        tg.addChild(caja);

        // Then add it to the rootBranchGroup
        rootBranchGroup.addChild(tg);

        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

      /*  MouseRotate myMouseRotate = new MouseRotate();
        myMouseRotate.setTransformGroup(tg);
        myMouseRotate.setSchedulingBounds(new BoundingSphere());
        rootBranchGroup.addChild(myMouseRotate);

        MouseTranslate myMouseTranslate = new MouseTranslate();
        myMouseTranslate.setTransformGroup(tg);
        myMouseTranslate.setSchedulingBounds(new BoundingSphere());
        rootBranchGroup.addChild(myMouseTranslate);

        MouseZoom myMouseZoom = new MouseZoom();
        myMouseZoom.setTransformGroup(tg);
        myMouseZoom.setSchedulingBounds(new BoundingSphere());
        rootBranchGroup.addChild(myMouseZoom);*/
        
        return rootBranchGroup;
      }
    
    public BranchGroup createSceneGraph3() {
    	BranchGroup objRoot = new BranchGroup();
    	TransformGroup objRotate = new TransformGroup();
    	objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    	
    	objRoot.addChild(objRotate);
    	objRotate.addChild(new ColorCube(0.4));
    	SimpleBehavior myRotationBehavior = new SimpleBehavior(objRotate);
    	myRotationBehavior.setSchedulingBounds(new BoundingSphere());
    	objRoot.addChild(myRotationBehavior);
    	objRoot.compile();
    	return objRoot;
    	} // end of CreateSceneGraph method of SimpleBehaviorApp
    
    /*
    public class SimpleBehavior extends Behavior{
    	private TransformGroup targetTG;
    	private Transform3D rotation = new Transform3D();
    	private double angle = 0.0;
    	// create SimpleBehavior - set TG object of change
    	SimpleBehavior(TransformGroup targetTG){
    	this.targetTG = targetTG;
    	}
    	// initialize the Behavior
    	// set initial wakeup condition
    	// called when behavior becomes live
    	public void initialize(){
    	this.wakeupOn(new
    	WakeupOnAWTEvent(KeyEvent.KEY_PRESSED));
    	}
    	// called by Java 3D when appropriate stimulus occurs
    	public void processStimulus(Enumeration criteria){
    	// do what is necessary in response to stimulus
    	angle += 0.1;
    	rotation.rotY(angle);
    	targetTG.setTransform(rotation);
    	this.wakeupOn(new
    	WakeupOnAWTEvent(KeyEvent.KEY_PRESSED));
    	}
    	} // end of class SimpleBehavior


	*/
}
