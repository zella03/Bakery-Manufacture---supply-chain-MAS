import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class CheckIfPrivate extends CyclicBehaviour<Supervisor> {
  private Supervisor __theAgent = (Supervisor)/*Used as metadata*/null;

  private AgentEnv<Supervisor, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public CheckIfPrivate(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static CheckIfPrivate __createEmpty(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new CheckIfPrivate(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event1.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event1.__eventFired) __awaitForEvents();
  }

  public Boolean __hasStaleMessageHandler() {
    return false;
  }

  private void __initializeAgentEnv() {
    this._agentEnv = jadescript.java.AgentEnv.agentEnv(__theAgent());
  }

  public BakeryOntology __ontology__BakeryOntology = (BakeryOntology) BakeryOntology.getInstance();

  public void __registerOntologies(final ContentManager cm) {
    super.__registerOntologies(cm);
    cm.registerOntology(BakeryOntology.getInstance());
  }

  public Codec __codec = new jade.content.lang.leap.LEAPCodec();

  protected Boolean noMorePrivateOrder = null;

  public void setNoMorePrivateOrder(final Boolean noMorePrivateOrder) {
    this.noMorePrivateOrder = noMorePrivateOrder;
  }

  public Boolean getNoMorePrivateOrder() {
    return this.noMorePrivateOrder;
  }

  private class __Event1 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement from line 100 to line 111
      	 * for order in orderList do
      	 *             if type of order = "private" do            
      	 *                 noMorePrivateOrder = false
      	 *                 break
      	 *                 
      	 *         # jednak może zrobić tak że jeżeli jest private Baker to on przed zapytaniem najpierw się pyta czy są jeszcze jakieś nowe private
      	 *         # jeżeli nie to się zamienia w normalsa
      	 *         # aaaaalbo Supervisor jeżeli pyta się private to wyśle wiadomość z nowym orderem i kontentem ze nie ma już private !!!!
      	 *             
      	 *         
      	 *         #if length of orderList % 8 != 0 do
      	 *             
      	 */
      	
      	for ( Order order : CheckIfPrivate.this._agentEnv.getAgent().getOrderList()) {
      		/* 
      		 * Compiled from source statement from line 101 to line 103
      		 * if type of order = "private" do            
      		 *                 noMorePrivateOrder = false
      		 *                 break
      		 */
      		
      		if(java.util.Objects.equals(order.getType(), "private")) {
      			/* 
      			 * Compiled from source statement at line 102
      			 * noMorePrivateOrder = false
      			 */
      			
      			CheckIfPrivate.this.setNoMorePrivateOrder(false);
      			
      			/* 
      			 * Compiled from source statement at line 103
      			 * break
      			 */
      			
      			break;
      		}
      	}
      }
      catch(jadescript.core.exception.JadescriptException __throwable) {
      	__handleJadescriptException(__throwable);
      }
      catch(java.lang.Throwable __throwable) {
      	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      }
    }
  }

  private CheckIfPrivate.__Event1 __event1 =  new CheckIfPrivate.__Event1();

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(CheckIfPrivate.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	CheckIfPrivate.this.noMorePrivateOrder = true;
    }
  }
}
