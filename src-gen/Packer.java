import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import jadescript.content.JadescriptProposition;
import jadescript.core.Agent;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.JadescriptAgentController;
import jadescript.java.SideEffectsFlag;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class Packer extends Agent {
  private Packer __theAgent = (Packer)/*Used as metadata*/null;

  private AgentEnv<Packer, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public BakeryOntology __ontology__BakeryOntology = (BakeryOntology) BakeryOntology.getInstance();

  public void __registerOntologies(final ContentManager cm) {
    super.__registerOntologies(cm);
    cm.registerOntology(BakeryOntology.getInstance());
  }

  public Codec __codec = new jade.content.lang.leap.LEAPCodec();

  protected String supervisorName = null;

  public void setSupervisorName(final String supervisorName) {
    this.supervisorName = supervisorName;
  }

  public String getSupervisorName() {
    return this.supervisorName;
  }

  protected JadescriptList<PackageOfGoods> packageList = null;

  public void setPackageList(final JadescriptList<PackageOfGoods> packageList) {
    this.packageList = packageList;
  }

  public JadescriptList<PackageOfGoods> getPackageList() {
    return this.packageList;
  }

  protected JadescriptList<Order> ordersReadyToPack = null;

  public void setOrdersReadyToPack(final JadescriptList<Order> ordersReadyToPack) {
    this.ordersReadyToPack = ordersReadyToPack;
  }

  public JadescriptList<Order> getOrdersReadyToPack() {
    return this.ordersReadyToPack;
  }

  protected JadescriptList<PackageOfGoods> finishedPackages = null;

  public void setFinishedPackages(final JadescriptList<PackageOfGoods> finishedPackages) {
    this.finishedPackages = finishedPackages;
  }

  public JadescriptList<PackageOfGoods> getFinishedPackages() {
    return this.finishedPackages;
  }

  protected JadescriptList<PackagePreparation> timeForPackage = null;

  public void setTimeForPackage(final JadescriptList<PackagePreparation> timeForPackage) {
    this.timeForPackage = timeForPackage;
  }

  public JadescriptList<PackagePreparation> getTimeForPackage() {
    return this.timeForPackage;
  }

  private void __onCreate() {
    java.lang.String supervisor = jadescript.util.types.JadescriptValueAdapter.adapt(this.getArguments()[0], new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT));
    try {
    	/* 
    	 * Compiled from source statement at line 9
    	 * supervisorName = supervisor
    	 */
    	
    	Packer.this.setSupervisorName(supervisor);
    	
    	/* 
    	 * Compiled from source statement at line 10
    	 * log "PACKER created with arguments: "+supervisor
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, Packer.this.getClass().getName(), Packer.this, "on create", java.lang.String.valueOf(java.lang.String.valueOf("PACKER created with arguments: ") + java.lang.String.valueOf(supervisor)));
    	
    	/* 
    	 * Compiled from source statement at line 12
    	 * activate DelayedPackerReady after "PT3S" as duration
    	 */
    	
    	new DelayedPackerReady(_agentEnv.getAgent().toEnv()).activate_after(_agentEnv.getAgent(), ((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT3S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))));
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(Packer.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  public void __handleBehaviourFailure(final jadescript.core.behaviours.Behaviour<?> __behaviour, final JadescriptProposition __reason) {
    boolean __handled = false;
    if(!__handled) {
    	jadescript.core.Agent.doLog(java.util.logging.Level.INFO, this.getClass().getName(), this, "<behaviour failure dispatcher>", "Behaviour " + __behaviour + " failed with reason: " + __reason);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	Packer.this.supervisorName = "";
    	
    	Packer.this.packageList = new jadescript.util.JadescriptList<PackageOfGoods>();
    	
    	Packer.this.ordersReadyToPack = new jadescript.util.JadescriptList<Order>();
    	
    	Packer.this.finishedPackages = new jadescript.util.JadescriptList<PackageOfGoods>();
    	
    	Packer.this.timeForPackage = new jadescript.util.JadescriptList<PackagePreparation>();
    }
  }

  private void __initializeAgentEnv() {
    this._agentEnv = jadescript.java.AgentEnv.agentEnv(__theAgent());
  }

  public Packer __theAgent() {
    return this;
  }

  protected void setup() {
    super.setup();
    __initializeAgentEnv();
    __initializeProperties();
    this.__onCreate();
  }

  protected void __registerCodecs(final ContentManager cm) {
    super.__registerCodecs(cm);
    cm.registerLanguage(__codec);
  }

  public static JadescriptAgentController create(final ContainerController _container, final String _agentName, final String supervisor) throws StaleProxyException {
    return jadescript.java.JadescriptAgentController.createRaw(_container, _agentName, Packer.class, supervisor);
  }
}
