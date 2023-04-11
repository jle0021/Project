import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.scene.shape.*;

public class Lab9Game extends Application
{

   public BorderPane bp = new BorderPane(); //border pane so i can have a top pane to put the text box in
   public Label text = new Label("Number of Balls: 14    Number of Moves: 2");
   public GridPane grid = new GridPane();
   public int numBall;
   public int numMoves;

   public GamePane [][] table = new GamePane [4][4];
   
   public void start(Stage stage)
   
   {
      bp.setPrefSize(600,600);
      
     
      text.setBackground(new Background(new BackgroundFill(Color.CYAN,CornerRadii.EMPTY, Insets.EMPTY))); //set the background to cycan
      text.setPrefSize(600,5); //set the cyan text to 500
      text.setAlignment(Pos.CENTER);
      bp.setTop(text); //put the text in the borderpane
      grid.setAlignment(Pos.CENTER);
      
      grid.setVgap(10);
      grid.setHgap(10);
      
      bp.setCenter(grid);

      for (int x = 0; x <4;x ++)
      {                             //4x4 array
        for (int y = 0; y<4; y++)
        {
           table[x][y] = new GamePane(x,y);
           
              if((x==0)&&(y==2))
              {
               table[0][2].setInvisible();
               grid.add(table[x][y],x,y); 
              }
           else
           {
              table[x][y].setButtonsInvisible();
              grid.add(table[x][y],x,y); 
           }
           
           table[x][y].draw(x,y);
    
        } 
      }
      
      buttonGenerator();     
            
      Scene scene = new Scene(bp, 600, 600); //other scene code here
      stage.setScene(scene);
      stage.setTitle("Lab7Game");
      stage.show();  
   }
   
  
   
   public void numBalls()
      {
         numBall=0;
         numMoves=0;
         
         for (int x = 0; x <4;x ++)
         {
            for (int y = 0; y <4;y ++)
            {
               
               if (table[x][y].getVisBall()==true)
               {
                  numBall++;
                  
               }
               
               
            
            }
         }
         
         for (int x = 0; x <4;x ++)
         {
            for (int y = 0; y <4;y ++)
            {
               
               if (table[x][y].getVisTop()==true)
               {
                  numMoves++;
                  
               }
               
               if (table[x][y].getVisBottom()==true)
               {
                  numMoves++;
                  
               }
               
               if (table[x][y].getVisLeft()==true)
               {
                  numMoves++;
                  
               }
               
               if (table[x][y].getVisRight()==true)
               {
                  numMoves++;
                  
               }
               
               
            
            }
         }
         
         text.setText("Number of Balls left: " +numBall+"    Number of Moves: " +numMoves);
         if ((numMoves == 0)&&(numBall>0))
         {
            lose();
         
         }
         
         if ((numMoves == 0)&&(numBall==1))
         {
            win();
         
         }
      } 
   
   
      public void win()
      {
      
         text.setText("YOU WIN!!!");
      }
      
      public void lose()
      {
      
         text.setText("you lose....looser");
      }
      
      
      
      
      
   public void click(int button, int buttonX_in, int buttonY_in)
      {
        int buttonX = buttonX_in;
        int buttonY = buttonY_in;
        
         if (button == 1)
         {
               for (int x = 0; x <4;x ++)
                        {                             //4x4 array
                          for (int y = 0; y<2;y++)
                          { 
                                if(table[x][y+2].getVisBall()==false)
                                {
                                    if((buttonX==x)&&(buttonY==y))
                                    {
                                       table[x][y+2].seeBall=true;
                                       table[x][y+1].seeBall=false;
                                       table[x][y].seeBall=false;
                                       table[x][y+2].draw(x,y+2);
                                       buttonGenerator(); 
                                    }
                                    
                                }                      
                                                         
                          } 
                        }
          }
          
          if (button == 2)
         {
                for (int x = 0; x <4;x ++)
                  {                             //4x4 array
                    for (int y = 2; y<4; y++)
                          { 
                                if(table[x][y-2].getVisBall()==false)
                                {
                                 if((buttonX==x)&&(buttonY==y))
                                 {
                                    table[x][y-2].seeBall=true;
                                    table[x][y-1].seeBall=false;
                                    table[x][y].seeBall=false;
                                    table[x][y-2].draw(x,y-2);
                                    buttonGenerator(); 
                                  }
                                }                      
                                                         
                          } 
                        }
          }
          
          if (button == 3)
         {
                for (int x = 0; x <2;x ++)
                        {                             //4x4 array
                          for (int y = 0; y<4; y++)
                          {
                             if(table[x+2][y].getVisBall()==false)
                                {
                                  if((buttonX==x)&&(buttonY==y))
                                  {
                                    table[x+2][y].seeBall=true;
                                    table[x+1][y].seeBall=false;
                                    table[x][y].seeBall=false;
                                    table[x+2][y].draw(x+2,y);
                                    buttonGenerator(); 
                                   }
                                }                      
                                                         
                          } 
                        }
          }
          
          if (button == 4)
         {
            boolean count = true;
                for (int x = 2; x <4;x++)
                     {                             //4x4 array
                       for (int y = 0; y<4; y++)
                       {
                          if(table[x-2][y].getVisBall()==false)
                                {
                                    if((buttonX==x)&&(buttonY==y))
                                    {
                                                                          
                                          System.out.println(table[x][y].getY());
                                          //System.out.println("in right");
                                          table[x-2][y].seeBall=true;
                                          table[x-1][y].seeBall=false;
                                          table[x][y].seeBall=false;
                                          table[x-2][y].draw(x-2,y);
                                          buttonGenerator(); 
                                      
                                    }
                                }                      
                                                         
                          } 
                        }
          }
          
          numBalls();
   }
   
   public void buttonGenerator()
      {
         for (int x = 0; x <4;x ++)
         {                             //4x4 array
           for (int y = 0; y<2; y++)
           {
               //System.out.println("in button generator1");
              if((table[x][y+2].getVisBall()==false)&&(table[x][y].getVisBall()==true)&&(table[x][y+1].getVisBall()==true))
              {
                  //System.out.println("in button generator2");
                  table[x][y].seeTop=true;
                  table[x][y].draw(x,y);
              }
              
              else
              {
                  //System.out.println("in button generator3");
                  table[x][y].seeTop=false;
                  table[x][y].draw(x,y);
              }      
            } 
         }
         
         for (int x = 0; x <4;x ++)
         {                             //4x4 array
           for (int y = 2; y<4; y++)
           {
              if((table[x][y-2].getVisBall()==false)&&(table[x][y].getVisBall()==true)&&(table[x][y-1].getVisBall()==true))
              {
                  
                  table[x][y].seeBottom=true;
                  table[x][y].draw(x,y);
              }
              
              else
              {
                  table[x][y].seeBottom=false;
                  table[x][y].draw(x,y);
              }      
            } 
         }
         
         for (int x = 0; x <2;x ++)
         {                             //4x4 array
           for (int y = 0; y<4; y++)
           {
              if((table[x+2][y].getVisBall()==false)&&(table[x][y].getVisBall()==true)&&(table[x+1][y].getVisBall()==true))
              {
                  
                  table[x][y].seeLeft=true;
                  table[x][y].draw(x,y);
              }
              
              else
              {
                  table[x][y].seeLeft=false;
                  table[x][y].draw(x,y);
              }      
            } 
         }


        for (int x = 2; x <4;x ++)
         {                             //4x4 array
           for (int y = 0; y<4; y++)
           {
              if((table[x-2][y].getVisBall()==false)&&(table[x][y].getVisBall()==true)&&(table[x-1][y].getVisBall()==true))
              {
                  
                  table[x][y].seeRight=true;
                  table[x][y].draw(x,y);
              }
              
              else
              {
                  table[x][y].seeRight=false;
                  table[x][y].draw(x,y);
              }      
            } 
         }
         
         
      }

                  
   public class GamePane extends GridPane  
   {
         private Button top = new Button();
         private Button bottom = new Button();
         private Button left = new Button();
         private Button right = new Button();         
                  
         private boolean seeBall = true;
         private boolean seeTop = true;
         private boolean seeBottom = true;
         private boolean seeLeft =true;
         private boolean seeRight = true;
         private Ellipse ball = new Ellipse();
         private int x;
         private int y;
         private int location;
      
          public GamePane(int x_in, int y_in)
          {  
            x = x_in;
            y = y_in;
            location = (y*4)+(x+1);
            
            setPrefSize(3,3);
            
            
            top.setOnAction(new ButtonListener());  
            top.setPrefSize(80,20);
            add(top,1,0);
            
            
            bottom.setOnAction(new ButtonListener());  
            bottom.setPrefSize(80,20);
            add(bottom,1,2);
            
            
            right.setOnAction(new ButtonListener());  
            right.setPrefSize(20,80);
            add(right,2,1);
            
            
            left.setOnAction(new ButtonListener());  
            left.setPrefSize(20,80);
            add(left,0,1);
            
            
            ball.setFill(Color.BLACK);
            ball.setRadiusX(40);
            ball.setRadiusY(40);
            add(ball,1,1);
          }
          
          public void setInvisible()
          {
             seeBall = false;
             seeTop = false;
             seeBottom = false;
             seeLeft =false;
             seeRight = false;
  
          }
          
          public void setButtonsInvisible()
          {
             
             seeTop = false;
             seeBottom = false;
             seeLeft =false;
             seeRight = false;
  
          }
          
          public boolean getVisBall()
          {
            return seeBall;
          }            
          
          public boolean getVisTop()
          {
            return seeTop;
          }
          
          public boolean getVisLeft()
          {
            return seeLeft;
          }
          
          public boolean getVisRight()
          {
            return seeRight;
          }
          
          public boolean getVisBottom()
          {
            return seeBottom;
          }
          public Ellipse getBall()
          {
            return ball;
          }            
          
          public Button getTop()
          {
            return top;
          }
          
          public Button getLeft()
          {
            return left;
          }
          
          public Button getRight()
          {
            return right;
          }
          
          public Button getBottom()
          {
            return bottom;
          }
          
          public int getLocation()
          {
             return location;
          }
          
          public int getX()
          {
             return x;
          }
          
          public int getY()
          {
             return y;
          }

          
          
          public class ButtonListener implements EventHandler<ActionEvent>  
            {
            public void handle(ActionEvent e) 
               {
               if(top==e.getSource())
                     {
                       
                        click(1,getX(),getY());     
                     }
               if(bottom==e.getSource())
                     {
                         click(2,getX(),getY());  
                         //System.out.println("click down");
                     }
               if(left==e.getSource())
                     {
                           click(3,getX(),getY());
                     }
               if(right==e.getSource())
                     {
                           click(4,getX(),getY());
                     }                
               }
            }

            public void draw(int x_in, int y_in)
            {
               int x = x_in;
               int y = y_in;
               
              try
               {                                          //for toggle you change the visibily to the surrounding buttons
                  if (seeBall == true)
                   {
                     table[x][y].getBall().setVisible(true);
                     
                   }
                  
                  else if (seeBall == false)
                   {
                     table[x][y].getBall().setVisible(false);

                   } 
                   
                   if (seeTop == true)
                   {
                     table[x][y].getTop().setVisible(true);
                     
                   }
                  
                  else if (seeTop == false)
                   {
                     table[x][y].getTop().setVisible(false);

                   } 
                   
                   if (seeBottom == true)
                   {
                     table[x][y].getBottom().setVisible(true);
                     
                   }
                  
                  else if (seeBottom == false)
                   {
                     table[x][y].getBottom().setVisible(false);

                   }
                   
                   if (seeLeft == true)
                   {
                     table[x][y].getLeft().setVisible(true);
                     
                   }
                  
                  else if (seeLeft == false)
                   {
                     table[x][y].getLeft().setVisible(false);
                   }
                   
                   if (seeRight == true)
                   {
                     table[x][y].getRight().setVisible(true);
                     
                   }
                  
                  else if (seeRight == false)
                   {
                     table[x][y].getRight().setVisible(false);
                   }


                                   
                }
                catch (ArrayIndexOutOfBoundsException e)  //if buttons are on the edge an excetion is caught bc they have no neighbors
                {
                  
                }
                  
            }
         

   }
     
   
   
   
public static void main(String[] args)
   {
      launch(args);
   }
}
 


