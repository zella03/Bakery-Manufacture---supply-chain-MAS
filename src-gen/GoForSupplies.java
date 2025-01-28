import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.OneShotBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class GoForSupplies extends OneShotBehaviour<Supplier> {
  private Supplier __theAgent = (Supplier)/*Used as metadata*/null;

  private AgentEnv<Supplier, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public GoForSupplies(final AgentEnv<? extends Supplier, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static GoForSupplies __createEmpty(final AgentEnv<? extends Supplier, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new GoForSupplies(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event0.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event0.__eventFired) __awaitForEvents();
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

  private class __Event0 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement at line 62
      	 * activate CurrentlyRestocking
      	 */
      	
      	new CurrentlyRestocking(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      	
      	/* 
      	 * Compiled from source statement at line 63
      	 * log "SUPPLIER'S STOCK before: "+listOfAvSupplies
      	 */
      	
      	jadescript.core.Agent.doLog(jade.util.Logger.INFO, GoForSupplies.this.getClass().getName(), GoForSupplies.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf("SUPPLIER'S STOCK before: ") + java.lang.String.valueOf(GoForSupplies.this._agentEnv.getAgent().getListOfAvSupplies())));
      	
      	/* 
      	 * Compiled from source statement from line 64 to line 66
      	 * for item in listOfAvSupplies do
      	 * 	        if quantity of item < 5 do
      	 * 	            quantity of item = 10
      	 */
      	
      	for ( IngredientQuantity item : GoForSupplies.this._agentEnv.getAgent().getListOfAvSupplies()) {
      		/* 
      		 * Compiled from source statement from line 65 to line 66
      		 * if quantity of item < 5 do
      		 * 	            quantity of item = 10
      		 */
      		
      		if(item.getQuantity() < 5) {
      			/* 
      			 * Compiled from source statement at line 66
      			 * quantity of item = 10
      			 */
      			
      			item.setQuantity(10);
      		}
      	}
      	
      	/* 
      	 * Compiled from source statement at line 68
      	 *  # restock for supplier
      	 * 	    
      	 * 	    runOutSupply = false
      	 */
      	
      	GoForSupplies.this._agentEnv.getAgent().setRunOutSupply(false);
      	
      	/* 
      	 * Compiled from source statement at line 69
      	 * log "SUPPLIER'S STOCK after: "+listOfAvSupplies
      	 */
      	
      	jadescript.core.Agent.doLog(jade.util.Logger.INFO, GoForSupplies.this.getClass().getName(), GoForSupplies.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf("SUPPLIER'S STOCK after: ") + java.lang.String.valueOf(GoForSupplies.this._agentEnv.getAgent().getListOfAvSupplies())));
      	
      	/* 
      	 * Compiled from source statement at line 70
      	 * activate ProvidingRestock after "PT2S" as duration
      	 */
      	
      	new ProvidingRestock(_agentEnv.getAgent().toEnv()).activate_after(_agentEnv.getAgent(), ((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT2S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))));
      	
      	/* 
      	 * Compiled from source statement at line 71
      	 * deactivate CurrentlyRestocking after "PT2S" as duration
      	 */
      	
      	new CurrentlyRestocking(_agentEnv.getAgent().toEnv()).deactivate_after(((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT2S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))));
      }
      catch(jadescript.core.exception.JadescriptException __throwable) {
      	__handleJadescriptException(__throwable);
      }
      catch(java.lang.Throwable __throwable) {
      	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      }
    }
  }

  private GoForSupplies.__Event0 __event0 =  new GoForSupplies.__Event0();

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(GoForSupplies.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    }
  }
}
