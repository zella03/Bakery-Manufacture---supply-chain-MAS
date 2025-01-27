import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class HandleIngredientsShortage extends CyclicBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public static HandleIngredientsShortage __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new HandleIngredientsShortage(_agentEnv, new jadescript.util.JadescriptList<IngredientQuantity>(), new Order());
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event5.run();
    __event6.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event5.__eventFired && !__event6.__eventFired) __awaitForEvents();
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

  protected JadescriptList<IngredientQuantity> listIngredientsNeeded = null;

  public void setListIngredientsNeeded(final JadescriptList<IngredientQuantity> listIngredientsNeeded) {
    this.listIngredientsNeeded = listIngredientsNeeded;
  }

  public JadescriptList<IngredientQuantity> getListIngredientsNeeded() {
    return this.listIngredientsNeeded;
  }

  protected Order order = null;

  public void setOrder(final Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return this.order;
  }

  protected JadescriptList<IngredientAvaliable> responds = null;

  public void setResponds(final JadescriptList<IngredientAvaliable> responds) {
    this.responds = responds;
  }

  public JadescriptList<IngredientAvaliable> getResponds() {
    return this.responds;
  }

  protected Boolean noHelpFromCo = null;

  public void setNoHelpFromCo(final Boolean noHelpFromCo) {
    this.noHelpFromCo = noHelpFromCo;
  }

  public Boolean getNoHelpFromCo() {
    return this.noHelpFromCo;
  }

  public HandleIngredientsShortage(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final JadescriptList<IngredientQuantity> listIngredientsNeeded, final Order order) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 173
    	 * listIngredientsNeeded of this = listIngredientsNeeded
    	 */
    	
    	HandleIngredientsShortage.this.setListIngredientsNeeded(listIngredientsNeeded);
    	
    	/* 
    	 * Compiled from source statement at line 174
    	 * order of this = order
    	 */
    	
    	HandleIngredientsShortage.this.setOrder(order);
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event5 {
    Boolean __eventFired = false;

    public void run() {
      if(HandleIngredientsShortage.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1696205526 {
      	public jade.core.AID id;
      	
      	public java.lang.Boolean avaliable;
      	
      	private final __PatternMatcher1696205526 __PatternMatcher1696205526_obj =  this;
      	
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
      		
      		avaliable = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		IngredientAvaliable __x;
      		
      		try {
      			if(__objx instanceof IngredientAvaliable) {
      				__x = (IngredientAvaliable) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getId()) && headerMatch_structterm1(__x.getAvaliable());
      	}
      }
      __PatternMatcher1696205526 __PatternMatcher1696205526_obj = new __PatternMatcher1696205526();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1696205526_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	HandleIngredientsShortage.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 177
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.InformMessage<IngredientAvaliable>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement at line 178
      			 * respond = IngredientAvaliable(id,avaliable)
      			 */
      			
      			IngredientAvaliable respond = BakeryOntology.IngredientAvaliable(__PatternMatcher1696205526_obj.id ,__PatternMatcher1696205526_obj.avaliable);
      			
      			/* 
      			 * Compiled from source statement from line 179 to line 182
      			 * if avaliable do
      			 *             log "Agent: "+ name of senderAgent + "has avaliable ingredients for :"+name of agent
      			 *         else do
      			 *             log "Agent: "+ name of senderAgent + "does NOT have avaliable ingredients for :"+name of agent
      			 */
      			
      			if(__PatternMatcher1696205526_obj.avaliable) {
      				/* 
      				 * Compiled from source statement at line 180
      				 * log "Agent: "+ name of senderAgent + "has avaliable ingredients for :"+name of agent
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(senderAgent.getName())) + java.lang.String.valueOf("has avaliable ingredients for :")) + java.lang.String.valueOf(HandleIngredientsShortage.this.getJadescriptAgent().getName())));
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 182
      				 * log "Agent: "+ name of senderAgent + "does NOT have avaliable ingredients for :"+name of agent
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(senderAgent.getName())) + java.lang.String.valueOf("does NOT have avaliable ingredients for :")) + java.lang.String.valueOf(HandleIngredientsShortage.this.getJadescriptAgent().getName())));
      			}
      			
      			/* 
      			 * Compiled from source statement at line 184
      			 * 
      			 *         
      			 *         add respond to responds
      			 */
      			
      			HandleIngredientsShortage.this.getResponds().add(respond);
      			
      			/* 
      			 * Compiled from source statement from line 185 to line 191
      			 * if length of responds = length of listOfCoworkers do
      			 *             for i in responds do
      			 * 		        if avaliable of i do
      			 * 		            log "Asking agent: "+ name of id of i + "for his avaliable ingredients for :"+name of agent
      			 * 		            send message request RequestIngredientsColleague(aid, listIngredientsNeeded) to id of i
      			 * 		            noHelpFromCo = false
      			 * 		            break
      			 */
      			
      			if(java.util.Objects.equals(HandleIngredientsShortage.this.getResponds().size(), HandleIngredientsShortage.this._agentEnv.getAgent().getListOfCoworkers().size())) {
      				/* 
      				 * Compiled from source statement from line 186 to line 191
      				 * for i in responds do
      				 * 		        if avaliable of i do
      				 * 		            log "Asking agent: "+ name of id of i + "for his avaliable ingredients for :"+name of agent
      				 * 		            send message request RequestIngredientsColleague(aid, listIngredientsNeeded) to id of i
      				 * 		            noHelpFromCo = false
      				 * 		            break
      				 */
      				
      				for ( IngredientAvaliable i : HandleIngredientsShortage.this.getResponds()) {
      					/* 
      					 * Compiled from source statement from line 187 to line 191
      					 * if avaliable of i do
      					 * 		            log "Asking agent: "+ name of id of i + "for his avaliable ingredients for :"+name of agent
      					 * 		            send message request RequestIngredientsColleague(aid, listIngredientsNeeded) to id of i
      					 * 		            noHelpFromCo = false
      					 * 		            break
      					 */
      					
      					if(i.getAvaliable()) {
      						/* 
      						 * Compiled from source statement at line 188
      						 * log "Asking agent: "+ name of id of i + "for his avaliable ingredients for :"+name of agent
      						 */
      						
      						jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Asking agent: ") + java.lang.String.valueOf(i.getId().getName())) + java.lang.String.valueOf("for his avaliable ingredients for :")) + java.lang.String.valueOf(HandleIngredientsShortage.this.getJadescriptAgent().getName())));
      						
      						/* 
      						 * Compiled from source statement at line 189
      						 * send message request RequestIngredientsColleague(aid, listIngredientsNeeded) to id of i
      						 */
      						
      						try {
      							jadescript.util.SendMessageUtils.validatePerformative("request");
      							
      							java.lang.Object _contentToBeSent1578296344 = BakeryOntology.RequestIngredientsColleague(HandleIngredientsShortage.this._agentEnv.getAgent().getAID() ,HandleIngredientsShortage.this.getListIngredientsNeeded());
      							
      							jadescript.core.message.Message _synthesizedMessage1578296344 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      							
      							_synthesizedMessage1578296344.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1578296344,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      							
      							_synthesizedMessage1578296344.setLanguage(__codec.getName());;
      							
      							_synthesizedMessage1578296344.addReceiver(i.getId());
      							
      							_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1578296344, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1578296344, "request"));
      							
      							_agentEnv.getAgent().send(_synthesizedMessage1578296344);
      						}
      						catch(java.lang.Throwable _t) {
      							throw jadescript.core.exception.JadescriptException.wrap(_t);
      						}
      						
      						/* 
      						 * Compiled from source statement at line 190
      						 * noHelpFromCo = false
      						 */
      						
      						HandleIngredientsShortage.this.setNoHelpFromCo(false);
      						
      						/* 
      						 * Compiled from source statement at line 191
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

  private HandleIngredientsShortage.__Event5 __event5 = null;

  private class __Event6 {
    Boolean __eventFired = false;

    public void run() {
      if(HandleIngredientsShortage.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1265530700 {
      	public jadescript.util.JadescriptList<IngredientQuantity> handedIngredients;
      	
      	private final __PatternMatcher1265530700 __PatternMatcher1265530700_obj =  this;
      	
      	public boolean headerMatch_structterm0(java.lang.Object __objx) {
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
      		
      		handedIngredients = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		ProvideIngredients __x;
      		
      		try {
      			if(__objx instanceof ProvideIngredients) {
      				__x = (ProvideIngredients) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getIngredients());
      	}
      }
      __PatternMatcher1265530700 __PatternMatcher1265530700_obj = new __PatternMatcher1265530700();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.REQUEST)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1265530700_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      	HandleIngredientsShortage.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 197
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.RequestMessage<ProvideIngredients>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement at line 198
      			 * log "Just got ingredients from: "+senderAgent
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("Just got ingredients from: ") + java.lang.String.valueOf(senderAgent)));
      			
      			/* 
      			 * Compiled from source statement from line 200 to line 203
      			 * for ingredient in handedIngredients do
      			 *             for item in stock do
      			 *                 if name of ingredient = name of item do
      			 *                    quantity of item = quantity of item + quantity of ingredient
      			 */
      			
      			for ( IngredientQuantity ingredient : __PatternMatcher1265530700_obj.handedIngredients) {
      				/* 
      				 * Compiled from source statement from line 201 to line 203
      				 * for item in stock do
      				 *                 if name of ingredient = name of item do
      				 *                    quantity of item = quantity of item + quantity of ingredient
      				 */
      				
      				for ( IngredientQuantity item : HandleIngredientsShortage.this._agentEnv.getAgent().getStock()) {
      					/* 
      					 * Compiled from source statement from line 202 to line 203
      					 * if name of ingredient = name of item do
      					 *                    quantity of item = quantity of item + quantity of ingredient
      					 */
      					
      					if(java.util.Objects.equals(ingredient.getName(), item.getName())) {
      						/* 
      						 * Compiled from source statement at line 203
      						 * quantity of item = quantity of item + quantity of ingredient
      						 */
      						
      						item.setQuantity(item.getQuantity() + ingredient.getQuantity());
      					}
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 205
      			 * 
      			 *         
      			 *         log "Fixed stock: "+stock
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, HandleIngredientsShortage.this.getClass().getName(), HandleIngredientsShortage.this, "on request", java.lang.String.valueOf(java.lang.String.valueOf("Fixed stock: ") + java.lang.String.valueOf(HandleIngredientsShortage.this._agentEnv.getAgent().getStock())));
      			
      			/* 
      			 * Compiled from source statement at line 206
      			 * activate PrepareOrder(order)
      			 */
      			
      			new PrepareOrder(_agentEnv.getAgent().toEnv() ,HandleIngredientsShortage.this.getOrder()).activate(_agentEnv.getAgent());
      			
      			/* 
      			 * Compiled from source statement at line 207
      			 * deactivate this
      			 */
      			
      			HandleIngredientsShortage.this.deactivate();
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

  private HandleIngredientsShortage.__Event6 __event6 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(HandleIngredientsShortage.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	HandleIngredientsShortage.this.listIngredientsNeeded = new jadescript.util.JadescriptList<IngredientQuantity>();
    	
    	HandleIngredientsShortage.this.order = new Order();
    	
    	HandleIngredientsShortage.this.responds = new jadescript.util.JadescriptList<IngredientAvaliable>();
    	
    	HandleIngredientsShortage.this.noHelpFromCo = true;
    	
    	__event5 = new HandleIngredientsShortage.__Event5();
    	
    	__event6 = new HandleIngredientsShortage.__Event6();
    }
  }
}
