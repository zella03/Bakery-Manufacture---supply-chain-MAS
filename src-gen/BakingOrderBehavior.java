import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;
import jadescript.lang.Duration;

@SuppressWarnings("all")
public class BakingOrderBehavior extends CyclicBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public static BakingOrderBehavior __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new BakingOrderBehavior(_agentEnv, new Order(), new jadescript.lang.Duration());
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event5.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event5.__eventFired) __awaitForEvents();
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

  protected Order order = null;

  public void setOrder(final Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return this.order;
  }

  protected Duration time = null;

  public void setTime(final Duration time) {
    this.time = time;
  }

  public Duration getTime() {
    return this.time;
  }

  protected Duration bakingTime = null;

  public void setBakingTime(final Duration bakingTime) {
    this.bakingTime = bakingTime;
  }

  public Duration getBakingTime() {
    return this.bakingTime;
  }

  public BakingOrderBehavior(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final Order order, final Duration bakingTime) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 339
    	 * order of this = order
    	 */
    	
    	BakingOrderBehavior.this.setOrder(order);
    	
    	/* 
    	 * Compiled from source statement at line 340
    	 * bakingTime of this = bakingTime
    	 */
    	
    	BakingOrderBehavior.this.setBakingTime(bakingTime);
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  /**
   * BakingOrderBehavior doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement at line 343
    	 * do chnageStatus with id of order,"baking"
    	 */
    	
    	BakingOrderBehavior.this._agentEnv.getAgent().chnageStatus(_agentEnv.getAgent().toEnv() ,BakingOrderBehavior.this.getOrder().getId() ,"baking");
    	
    	/* 
    	 * Compiled from source statement at line 344
    	 * status of order = "baking"
    	 */
    	
    	BakingOrderBehavior.this.getOrder().setStatus("baking");
    	
    	/* 
    	 * Compiled from source statement at line 345
    	 * log "Agent: "+name of agent+" started baking for: " + good of order
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, BakingOrderBehavior.this.getClass().getName(), BakingOrderBehavior.this, "on activate", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(BakingOrderBehavior.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" started baking for: ")) + java.lang.String.valueOf(BakingOrderBehavior.this.getOrder().getGood())));
    	
    	/* 
    	 * Compiled from source statement at line 346
    	 * time = now as duration
    	 */
    	
    	BakingOrderBehavior.this.setTime(((jadescript.lang.Duration) jadescript.util.types.Converter.convert(jadescript.lang.Timestamp.now(), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TIMESTAMP), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))));
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event5 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement from line 350 to line 359
      	 * if (now - time) as duration >= bakingTime as duration do
      	 *             log "Agent: "+name of agent+" finished baking: "+good of order+" of id: "+ id of order
      	 *             do chnageStatus with id of order,"finished"
      	 *             status of order = "finished"
      	 *             for orderWithStat in ordersList do
      	 *                 if id of order = orderId of orderWithStat do
      	 *                     log orderWithStat
      	 *                     send message inform orderWithStat to aid
      	 *                     deactivate this
      	 *                     break
      	 */
      	
      	if(jadescript.lang.Duration.compare(((jadescript.lang.Duration) jadescript.util.types.Converter.convert((jadescript.lang.Timestamp.minus(jadescript.lang.Timestamp.now(), BakingOrderBehavior.this.getTime())), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TIMESTAMP), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))), ((jadescript.lang.Duration) jadescript.util.types.Converter.convert(BakingOrderBehavior.this.getBakingTime(), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION)))) >= 0) {
      		/* 
      		 * Compiled from source statement at line 351
      		 * log "Agent: "+name of agent+" finished baking: "+good of order+" of id: "+ id of order
      		 */
      		
      		jadescript.core.Agent.doLog(jade.util.Logger.INFO, BakingOrderBehavior.this.getClass().getName(), BakingOrderBehavior.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(BakingOrderBehavior.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" finished baking: ")) + java.lang.String.valueOf(BakingOrderBehavior.this.getOrder().getGood())) + java.lang.String.valueOf(" of id: ")) + java.lang.String.valueOf(BakingOrderBehavior.this.getOrder().getId())));
      		
      		/* 
      		 * Compiled from source statement at line 352
      		 * do chnageStatus with id of order,"finished"
      		 */
      		
      		BakingOrderBehavior.this._agentEnv.getAgent().chnageStatus(_agentEnv.getAgent().toEnv() ,BakingOrderBehavior.this.getOrder().getId() ,"finished");
      		
      		/* 
      		 * Compiled from source statement at line 353
      		 * status of order = "finished"
      		 */
      		
      		BakingOrderBehavior.this.getOrder().setStatus("finished");
      		
      		/* 
      		 * Compiled from source statement from line 354 to line 359
      		 * for orderWithStat in ordersList do
      		 *                 if id of order = orderId of orderWithStat do
      		 *                     log orderWithStat
      		 *                     send message inform orderWithStat to aid
      		 *                     deactivate this
      		 *                     break
      		 */
      		
      		for ( OrderStatus orderWithStat : BakingOrderBehavior.this._agentEnv.getAgent().getOrdersList()) {
      			/* 
      			 * Compiled from source statement from line 355 to line 359
      			 * if id of order = orderId of orderWithStat do
      			 *                     log orderWithStat
      			 *                     send message inform orderWithStat to aid
      			 *                     deactivate this
      			 *                     break
      			 */
      			
      			if(java.util.Objects.equals(BakingOrderBehavior.this.getOrder().getId(), orderWithStat.getOrderId())) {
      				/* 
      				 * Compiled from source statement at line 356
      				 * log orderWithStat
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, BakingOrderBehavior.this.getClass().getName(), BakingOrderBehavior.this, "on execute", java.lang.String.valueOf(orderWithStat));
      				
      				/* 
      				 * Compiled from source statement at line 357
      				 * send message inform orderWithStat to aid
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent1869150912 = orderWithStat;
      					
      					jadescript.core.message.Message _synthesizedMessage1869150912 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage1869150912.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1869150912,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage1869150912.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage1869150912.addReceiver(BakingOrderBehavior.this._agentEnv.getAgent().getAID());
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1869150912, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1869150912, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage1869150912);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      				
      				/* 
      				 * Compiled from source statement at line 358
      				 * deactivate this
      				 */
      				
      				BakingOrderBehavior.this.deactivate();
      				
      				/* 
      				 * Compiled from source statement at line 359
      				 * break
      				 */
      				
      				break;
      			}
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

  private BakingOrderBehavior.__Event5 __event5 =  new BakingOrderBehavior.__Event5();

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(BakingOrderBehavior.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	BakingOrderBehavior.this.order = new Order();
    	
    	BakingOrderBehavior.this.time = new jadescript.lang.Duration();
    	
    	BakingOrderBehavior.this.bakingTime = new jadescript.lang.Duration();
    }
  }
}
