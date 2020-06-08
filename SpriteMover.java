
public class SpriteMover implements Runnable
{
    Model model;
    View view;
    
    public SpriteMover(Model model, View view)
    {
        this.model = model;
        this.view = view;
        
    }
    

    @Override
    public void run()
    {
        while(true)
        {
            synchronized(Sprite.class)
            {
               model.updateScene(view.getWidth(), view.getHeight());
               view.repaint();
            }
            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException e)
            {
                
            }
        }
    }
}
