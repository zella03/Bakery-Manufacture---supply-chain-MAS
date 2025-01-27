import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class ListenCoworkers extends CyclicBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public ListenCoworkers(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
  }

  public static ListenCoworkers __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new ListenCoworkers(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event2.run();
    __event3.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event2.__eventFired && !__event3.__eventFired) __awaitForEvents();
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

  protected Boolean avaliable = null;

  public void setAvaliable(final Boolean avaliable) {
    this.avaliable = avaliable;
  }

  public Boolean getAvaliable() {
    return this.avaliable;
  }

  protected JadescriptList<IngredientQuantity> providedIngredients = null;

  public void setProvidedIngredients(final JadescriptList<IngredientQuantity> providedIngredients) {
    this.providedIngredients = providedIngredients;
  }

  public JadescriptList<IngredientQuantity> getProvidedIngredients() {
    return this.providedIngredients;
  }

  private class __Event2 {
    Boolean __eventFired = false;

    public void run() {
      if(ListenCoworkers.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1161558031 {
      	public jade.core.AID agentId;
      	
      	public jadescript.util.JadescriptList<IngredientQuantity> ingredients;
      	
      	private final __PatternMatcher1161558031 __PatternMatcher1161558031_obj =  this;
      	
      	public boolean headerMatch_structterm0_typecast0(java.lang.Object __objx) {
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
      		
      		agentId = __x;
      		
      		return true;
      	}
      	
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
      		
      		return true && headerMatch_structterm0_typecast0(__x);
      	}
      	
      	public boolean headerMatch_structterm1_typecast0(java.lang.Object __objx) {
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
      		
      		ingredients = __x;
      		
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
      		
      		return true && headerMatch_structterm1_typecast0(__x);
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		AskForHelpColleague __x;
      		
      		try {
      			if(__objx instanceof AskForHelpColleague) {
      				__x = (AskForHelpColleague) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getAgentId()) && headerMatch_structterm1(__x.getIngredients());
      	}
      }
      __PatternMatcher1161558031 __PatternMatcher1161558031_obj = new __PatternMatcher1161558031();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1161558031_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ListenCoworkers.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 135
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<AskForHelpColleague>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement at line 137
      			 * log "Agent: "+name of agent +" received a request for help from "+ name of senderAgent
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(ListenCoworkers.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" received a request for help from ")) + java.lang.String.valueOf(senderAgent.getName())));
      			
      			/* 
      			 * Compiled from source statement at line 138
      			 * log "Needed ingredients: "+ingredients
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("Needed ingredients: ") + java.lang.String.valueOf(__PatternMatcher1161558031_obj.ingredients)));
      			
      			/* 
      			 * Compiled from source statement from line 140 to line 146
      			 * for ingredient in ingredients do
      			 *             for item in stock do
      			 *                 if quantity of ingredient > quantity of item do
      			 *                    log "Agent wants too much: "+ quantity of ingredient + " but i have "+ quantity of item
      			 *                    send message inform IngredientAvaliable(aid, false) to senderAgent
      			 *                    avaliable = false
      			 *                    break
      			 */
      			
      			for ( IngredientQuantity ingredient : __PatternMatcher1161558031_obj.ingredients) {
      				/* 
      				 * Compiled from source statement from line 141 to line 146
      				 * for item in stock do
      				 *                 if quantity of ingredient > quantity of item do
      				 *                    log "Agent wants too much: "+ quantity of ingredient + " but i have "+ quantity of item
      				 *                    send message inform IngredientAvaliable(aid, false) to senderAgent
      				 *                    avaliable = false
      				 *                    break
      				 */
      				
      				for ( IngredientQuantity item : ListenCoworkers.this._agentEnv.getAgent().getStock()) {
      					/* 
      					 * Compiled from source statement from line 142 to line 146
      					 * if quantity of ingredient > quantity of item do
      					 *                    log "Agent wants too much: "+ quantity of ingredient + " but i have "+ quantity of item
      					 *                    send message inform IngredientAvaliable(aid, false) to senderAgent
      					 *                    avaliable = false
      					 *                    break
      					 */
      					
      					if(ingredient.getQuantity() > item.getQuantity()) {
      						/* 
      						 * Compiled from source statement at line 143
      						 * log "Agent wants too much: "+ quantity of ingredient + " but i have "+ quantity of item
      						 */
      						
      						jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent wants too much: ") + java.lang.String.valueOf(ingredient.getQuantity())) + java.lang.String.valueOf(" but i have ")) + java.lang.String.valueOf(item.getQuantity())));
      						
      						/* 
      						 * Compiled from source statement at line 144
      						 * send message inform IngredientAvaliable(aid, false) to senderAgent
      						 */
      						
      						try {
      							jadescript.util.SendMessageUtils.validatePerformative("inform");
      							
      							java.lang.Object _contentToBeSent1092009121 = BakeryOntology.IngredientAvaliable(ListenCoworkers.this._agentEnv.getAgent().getAID() ,false);
      							
      							jadescript.core.message.Message _synthesizedMessage1092009121 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      							
      							_synthesizedMessage1092009121.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1092009121,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      							
      							_synthesizedMessage1092009121.setLanguage(__codec.getName());;
      							
      							_synthesizedMessage1092009121.addReceiver(senderAgent);
      							
      							_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1092009121, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1092009121, "inform"));
      							
      							_agentEnv.getAgent().send(_synthesizedMessage1092009121);
      						}
      						catch(java.lang.Throwable _t) {
      							throw jadescript.core.exception.JadescriptException.wrap(_t);
      						}
      						
      						/* 
      						 * Compiled from source statement at line 145
      						 * avaliable = false
      						 */
      						
      						ListenCoworkers.this.setAvaliable(false);
      						
      						/* 
      						 * Compiled from source statement at line 146
      						 * break
      						 */
      						
      						break;
      					}
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement from line 148 to line 149
      			 * 
      			 *         
      			 *         if avaliable do
      			 *             send message inform IngredientAvaliable(aid, true) to senderAgent
      			 */
      			
      			if(ListenCoworkers.this.getAvaliable()) {
      				/* 
      				 * Compiled from source statement at line 149
      				 * send message inform IngredientAvaliable(aid, true) to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent782746485 = BakeryOntology.IngredientAvaliable(ListenCoworkers.this._agentEnv.getAgent().getAID() ,true);
      					
      					jadescript.core.message.Message _synthesizedMessage782746485 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage782746485.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent782746485,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage782746485.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage782746485.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage782746485, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent782746485, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage782746485);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
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

  private ListenCoworkers.__Event2 __event2 = null;

  private class __Event3 {
    Boolean __eventFired = false;

    public void run() {
      if(ListenCoworkers.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1978160894 {
      	public jade.core.AID id;
      	
      	public jadescript.util.JadescriptList<IngredientQuantity> listIngredientsNeeded;
      	
      	private final __PatternMatcher1978160894 __PatternMatcher1978160894_obj =  this;
      	
      	public boolean headerMatch_structterm0_typecast0(java.lang.Object __objx) {
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
      		
      		return true && headerMatch_structterm0_typecast0(__x);
      	}
      	
      	public boolean headerMatch_structterm1_typecast0(java.lang.Object __objx) {
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
      		
      		listIngredientsNeeded = __x;
      		
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
      		
      		return true && headerMatch_structterm1_typecast0(__x);
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		RequestIngredientsColleague __x;
      		
      		try {
      			if(__objx instanceof RequestIngredientsColleague) {
      				__x = (RequestIngredientsColleague) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getAgentId()) && headerMatch_structterm1(__x.getIngredients());
      	}
      }
      __PatternMatcher1978160894 __PatternMatcher1978160894_obj = new __PatternMatcher1978160894();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1978160894_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	ListenCoworkers.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 152
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<RequestIngredientsColleague>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 154 to line 158
      			 * for ingredient in listIngredientsNeeded do
      			 *             for item in stock do
      			 *                 if name of ingredient = name of item do
      			 *                    quantity of item = quantity of item - quantity of ingredient
      			 *                    add IngredientQuantity(name of ingredient, quantity of ingredient) to providedIngredients
      			 */
      			
      			for ( IngredientQuantity ingredient : __PatternMatcher1978160894_obj.listIngredientsNeeded) {
      				/* 
      				 * Compiled from source statement from line 155 to line 158
      				 * for item in stock do
      				 *                 if name of ingredient = name of item do
      				 *                    quantity of item = quantity of item - quantity of ingredient
      				 *                    add IngredientQuantity(name of ingredient, quantity of ingredient) to providedIngredients
      				 */
      				
      				for ( IngredientQuantity item : ListenCoworkers.this._agentEnv.getAgent().getStock()) {
      					/* 
      					 * Compiled from source statement from line 156 to line 158
      					 * if name of ingredient = name of item do
      					 *                    quantity of item = quantity of item - quantity of ingredient
      					 *                    add IngredientQuantity(name of ingredient, quantity of ingredient) to providedIngredients
      					 */
      					
      					if(java.util.Objects.equals(ingredient.getName(), item.getName())) {
      						/* 
      						 * Compiled from source statement at line 157
      						 * quantity of item = quantity of item - quantity of ingredient
      						 */
      						
      						item.setQuantity(item.getQuantity() - ingredient.getQuantity());
      						
      						/* 
      						 * Compiled from source statement at line 158
      						 * add IngredientQuantity(name of ingredient, quantity of ingredient) to providedIngredients
      						 */
      						
      						ListenCoworkers.this.getProvidedIngredients().add(BakeryOntology.IngredientQuantity(ingredient.getName() ,ingredient.getQuantity()));
      					}
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 160
      			 * 
      			 *         
      			 *         log "Items that are beeing send: "+providedIngredients +" by: "+name of agent
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Items that are beeing send: ") + java.lang.String.valueOf(ListenCoworkers.this.getProvidedIngredients())) + java.lang.String.valueOf(" by: ")) + java.lang.String.valueOf(ListenCoworkers.this.getJadescriptAgent().getName())));
      			
      			/* 
      			 * Compiled from source statement at line 161
      			 * log "My current stock after helping: "+stock
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, ListenCoworkers.this.getClass().getName(), ListenCoworkers.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("My current stock after helping: ") + java.lang.String.valueOf(ListenCoworkers.this._agentEnv.getAgent().getStock())));
      			
      			/* 
      			 * Compiled from source statement at line 163
      			 * send message request ProvideIngredients(providedIngredients) to senderAgent
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent1746793422 = BakeryOntology.ProvideIngredients(ListenCoworkers.this.getProvidedIngredients());
      				
      				jadescript.core.message.Message _synthesizedMessage1746793422 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage1746793422.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1746793422,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1746793422.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1746793422.addReceiver(senderAgent);
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1746793422, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1746793422, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1746793422);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
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

  private ListenCoworkers.__Event3 __event3 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(ListenCoworkers.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	ListenCoworkers.this.avaliable = true;
    	
    	ListenCoworkers.this.providedIngredients = new jadescript.util.JadescriptList<IngredientQuantity>();
    	
    	__event2 = new ListenCoworkers.__Event2();
    	
    	__event3 = new ListenCoworkers.__Event3();
    }
  }
}
