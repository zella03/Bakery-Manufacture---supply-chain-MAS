import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class ProvidingRestock extends CyclicBehaviour<Supplier> {
  private Supplier __theAgent = (Supplier)/*Used as metadata*/null;

  private AgentEnv<Supplier, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public ProvidingRestock(final AgentEnv<? extends Supplier, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static ProvidingRestock __createEmpty(final AgentEnv<? extends Supplier, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new ProvidingRestock(_agentEnv);
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

  protected JadescriptList<IngredientQuantity> itemsToProvide = null;

  public void setItemsToProvide(final JadescriptList<IngredientQuantity> itemsToProvide) {
    this.itemsToProvide = itemsToProvide;
  }

  public JadescriptList<IngredientQuantity> getItemsToProvide() {
    return this.itemsToProvide;
  }

  private class __Event1 {
    Boolean __eventFired = false;

    public void run() {
      if(ProvidingRestock.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1453542392 {
      	public jade.core.AID id;
      	
      	public jadescript.util.JadescriptList<IngredientQuantity> stock;
      	
      	public java.lang.Boolean whilePreparing;
      	
      	private final __PatternMatcher1453542392 __PatternMatcher1453542392_obj =  this;
      	
      	public boolean headerMatch_structterm0(java.lang.Object __objx) {
      		jade.core.AID __x;
      		
      		try {
      			if(__objx instanceof jade.core.AID) {
      				__x = (jade.core.AID) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		id = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm1(java.lang.Object __objx) {
      		jadescript.util.JadescriptList<IngredientQuantity> __x;
      		
      		try {
      			if(__objx instanceof jadescript.util.JadescriptList) {
      				__x = (jadescript.util.JadescriptList<IngredientQuantity>) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		stock = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm2(java.lang.Object __objx) {
      		java.lang.Boolean __x;
      		
      		try {
      			if(__objx instanceof java.lang.Boolean) {
      				__x = (java.lang.Boolean) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		whilePreparing = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		NeedRestock __x;
      		
      		try {
      			if(__objx instanceof NeedRestock) {
      				__x = (NeedRestock) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getAgentId()) && headerMatch_structterm1(__x.getIngredients()) && headerMatch_structterm2(__x.getWhileProparing());
      	}
      }
      __PatternMatcher1453542392 __PatternMatcher1453542392_obj = new __PatternMatcher1453542392();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1453542392_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
      	}
      	catch(java.lang.Throwable _e) {
      		_e.printStackTrace();
      		
      		return false;
      	}
      }
      }))));
      jadescript.core.message.Message __receivedMessage = null;
      if(myAgent!=null) {
      	__receivedMessage = jadescript.core.message.Message.wrap(myAgent.receive(__mt));
      }
      if(__receivedMessage != null) {
      	ProvidingRestock.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 41
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<NeedRestock>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 43 to line 45
      			 * if length of stock = 0 do
      			 * 	        log "ERROR: Received empty stock from " + sender of message
      			 * 	        return
      			 */
      			
      			if(java.util.Objects.equals(__PatternMatcher1453542392_obj.stock.size(), 0)) {
      				/* 
      				 * Compiled from source statement at line 44
      				 * log "ERROR: Received empty stock from " + sender of message
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, ProvidingRestock.this.getClass().getName(), ProvidingRestock.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("ERROR: Received empty stock from ") + java.lang.String.valueOf(((jadescript.core.message.RequestMessage<NeedRestock>) __receivedMessage).getSender())));
      				
      				/* 
      				 * Compiled from source statement at line 45
      				 * return
      				 */
      				
      				return ;
      			}
      			
      			/* 
      			 * Compiled from source statement at line 46
      			 * 
      			 * 	    log "Received NeedRestock from " + sender of message + " with stock: " + stock
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ProvidingRestock.this.getClass().getName(), ProvidingRestock.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Received NeedRestock from ") + java.lang.String.valueOf(((jadescript.core.message.RequestMessage<NeedRestock>) __receivedMessage).getSender())) + java.lang.String.valueOf(" with stock: ")) + java.lang.String.valueOf(__PatternMatcher1453542392_obj.stock)));
      			
      			/* 
      			 * Compiled from source statement from line 48 to line 55
      			 * for item in stock do
      			 *             for ingredient in listOfAvSupplies do
      			 * 	            if ingredientName of item = ingredientName of ingredient and quantity of item ≤ 4 and quantity of ingredient ≥ 6 do
      			 * 	               quantity of ingredient = quantity of ingredient - 6
      			 * 	               add IngredientQuantity(ingredientName of item,6) to itemsToProvide
      			 * 	            
      			 * 	            if quantity of ingredient < 6 do
      			 * 	               runOutSupply = true
      			 */
      			
      			for ( IngredientQuantity item : __PatternMatcher1453542392_obj.stock) {
      				/* 
      				 * Compiled from source statement from line 49 to line 55
      				 * for ingredient in listOfAvSupplies do
      				 * 	            if ingredientName of item = ingredientName of ingredient and quantity of item ≤ 4 and quantity of ingredient ≥ 6 do
      				 * 	               quantity of ingredient = quantity of ingredient - 6
      				 * 	               add IngredientQuantity(ingredientName of item,6) to itemsToProvide
      				 * 	            
      				 * 	            if quantity of ingredient < 6 do
      				 * 	               runOutSupply = true
      				 */
      				
      				for ( IngredientQuantity ingredient : ProvidingRestock.this._agentEnv.getAgent().getListOfAvSupplies()) {
      					/* 
      					 * Compiled from source statement from line 50 to line 52
      					 * if ingredientName of item = ingredientName of ingredient and quantity of item ≤ 4 and quantity of ingredient ≥ 6 do
      					 * 	               quantity of ingredient = quantity of ingredient - 6
      					 * 	               add IngredientQuantity(ingredientName of item,6) to itemsToProvide
      					 */
      					
      					if(java.util.Objects.equals(item.getIngredientName(), ingredient.getIngredientName()) && item.getQuantity() <= 4 && ingredient.getQuantity() >= 6) {
      						/* 
      						 * Compiled from source statement at line 51
      						 * quantity of ingredient = quantity of ingredient - 6
      						 */
      						
      						ingredient.setQuantity(ingredient.getQuantity() - 6);
      						
      						/* 
      						 * Compiled from source statement at line 52
      						 * add IngredientQuantity(ingredientName of item,6) to itemsToProvide
      						 */
      						
      						ProvidingRestock.this.getItemsToProvide().add(BakeryOntology.IngredientQuantity(item.getIngredientName() ,6));
      					}
      					
      					/* 
      					 * Compiled from source statement from line 54 to line 55
      					 * 
      					 * 	            
      					 * 	            if quantity of ingredient < 6 do
      					 * 	               runOutSupply = true
      					 */
      					
      					if(ingredient.getQuantity() < 6) {
      						/* 
      						 * Compiled from source statement at line 55
      						 * runOutSupply = true
      						 */
      						
      						ProvidingRestock.this._agentEnv.getAgent().setRunOutSupply(true);
      					}
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement from line 57 to line 60
      			 * 
      			 *         
      			 *         if length of itemsToProvide ≠ 0 do
      			 *             log "SUPPLIER sends supplies: "+itemsToProvide
      			 *             send message request ProvideIngredients(itemsToProvide,whilePreparing) to senderAgent
      			 *             itemsToProvide = [] of IngredientQuantity
      			 */
      			
      			if(!java.util.Objects.equals(ProvidingRestock.this.getItemsToProvide().size(), 0)) {
      				/* 
      				 * Compiled from source statement at line 58
      				 * log "SUPPLIER sends supplies: "+itemsToProvide
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, ProvidingRestock.this.getClass().getName(), ProvidingRestock.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("SUPPLIER sends supplies: ") + java.lang.String.valueOf(ProvidingRestock.this.getItemsToProvide())));
      				
      				/* 
      				 * Compiled from source statement at line 59
      				 * send message request ProvideIngredients(itemsToProvide,whilePreparing) to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("request");
      					
      					java.lang.Object _contentToBeSent1023753751 = BakeryOntology.ProvideIngredients(ProvidingRestock.this.getItemsToProvide() ,__PatternMatcher1453542392_obj.whilePreparing);
      					
      					jadescript.core.message.Message _synthesizedMessage1023753751 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      					
      					_synthesizedMessage1023753751.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1023753751,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage1023753751.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage1023753751.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1023753751, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1023753751, "request"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage1023753751);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      				
      				/* 
      				 * Compiled from source statement at line 60
      				 * itemsToProvide = [] of IngredientQuantity
      				 */
      				
      				ProvidingRestock.this.setItemsToProvide(new jadescript.util.JadescriptList<IngredientQuantity>());
      			}
      			
      			/* 
      			 * Compiled from source statement at line 62
      			 * 
      			 *         
      			 *         log "Supplier list av: "+listOfAvSupplies
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ProvidingRestock.this.getClass().getName(), ProvidingRestock.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("Supplier list av: ") + java.lang.String.valueOf(ProvidingRestock.this._agentEnv.getAgent().getListOfAvSupplies())));
      			
      			/* 
      			 * Compiled from source statement at line 63
      			 * log "Supplier run out: "+runOutSupply
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ProvidingRestock.this.getClass().getName(), ProvidingRestock.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("Supplier run out: ") + java.lang.String.valueOf(ProvidingRestock.this._agentEnv.getAgent().getRunOutSupply())));
      			
      			/* 
      			 * Compiled from source statement from line 64 to line 67
      			 * if runOutSupply do
      			 *             activate GoForSupplies
      			 *             #send message inform SupplierRunOutSupply to aid of agent
      			 *             deactivate this
      			 */
      			
      			if(ProvidingRestock.this._agentEnv.getAgent().getRunOutSupply()) {
      				/* 
      				 * Compiled from source statement at line 65
      				 * activate GoForSupplies
      				 */
      				
      				new GoForSupplies(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      				
      				/* 
      				 * Compiled from source statement at line 67
      				 * deactivate this
      				 */
      				
      				ProvidingRestock.this.deactivate();
      			}
      		}
      		catch(jadescript.core.exception.JadescriptException __throwable) {
      			__handleJadescriptException(__throwable);
      		}
      		catch(java.lang.Throwable __throwable) {
      			__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      		}
      		
      		__receivedMessage = null;
      	}
      	catch(Exception _e) {
      		_e.printStackTrace();
      	}
      }
      else {
      	this.__eventFired = false;
      }
    }
  }

  private ProvidingRestock.__Event1 __event1 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(ProvidingRestock.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	ProvidingRestock.this.itemsToProvide = new jadescript.util.JadescriptList<IngredientQuantity>();
    	
    	__event1 = new ProvidingRestock.__Event1();
    }
  }
}
