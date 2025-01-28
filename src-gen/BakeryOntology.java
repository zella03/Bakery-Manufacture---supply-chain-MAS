import jade.core.AID;
import jadescript.content.onto.Ontology;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.lang.Duration;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class BakeryOntology extends Ontology implements BakeryOntology_Vocabulary {
  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(BakeryOntology.this);
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

  private static Ontology _superOntology = null;

  private static Ontology __instance = new BakeryOntology();

  public static final String __NAME = "BakeryOntology";

  public static Ontology getInstance() {
    return __instance;
  }

  public static IngredientQuantity IngredientQuantity(final String ingredientName, final Integer quantity) {
    return new IngredientQuantity(ingredientName, quantity);
  }

  public static Good Good(final String name, final JadescriptList<IngredientQuantity> ingredients, final Duration bakingTime, final Duration preparationTime, final Integer batchSize) {
    return new Good(name, __ListClass_IngredientQuantity.__fromList(ingredients), bakingTime, preparationTime, batchSize);
  }

  public static class __ListClass_IngredientQuantity extends JadescriptList<IngredientQuantity> {
    public static __ListClass_IngredientQuantity __fromList(final JadescriptList<IngredientQuantity> list) {
      __ListClass_IngredientQuantity result = new __ListClass_IngredientQuantity();
      java.util.List<IngredientQuantity> elements = new java.util.ArrayList<>();
      list.forEach(elements::add);
      result.setElements(elements);
      return result;
    }
  }

  public static OrderQuantity OrderQuantity(final String good, final String type, final Integer quantity) {
    return new OrderQuantity(good, type, quantity);
  }

  public static Order Order(final String id, final String good, final String status, final String type) {
    return new Order(id, good, status, type);
  }

  public static PackageOfGoods PackageOfGoods(final String packageId, final JadescriptList<OrderQuantity> ordersInPackage, final String status) {
    return new PackageOfGoods(packageId, __ListClass_OrderQuantity.__fromList(ordersInPackage), status);
  }

  public static class __ListClass_OrderQuantity extends JadescriptList<OrderQuantity> {
    public static __ListClass_OrderQuantity __fromList(final JadescriptList<OrderQuantity> list) {
      __ListClass_OrderQuantity result = new __ListClass_OrderQuantity();
      java.util.List<OrderQuantity> elements = new java.util.ArrayList<>();
      list.forEach(elements::add);
      result.setElements(elements);
      return result;
    }
  }

  public static RequestOrder RequestOrder(final AID agentId) {
    return new RequestOrder(agentId);
  }

  public static AssignOrder AssignOrder(final AID agentId, final Order order) {
    return new AssignOrder(agentId, order);
  }

  public static RequestIngredients RequestIngredients(final AID agentId, final JadescriptList<IngredientQuantity> ingredients) {
    return new RequestIngredients(agentId, __ListClass_IngredientQuantity.__fromList(ingredients));
  }

  public static AskForHelpColleague AskForHelpColleague(final AID agentId, final JadescriptList<IngredientQuantity> ingredients) {
    return new AskForHelpColleague(agentId, __ListClass_IngredientQuantity.__fromList(ingredients));
  }

  public static RequestIngredientsColleague RequestIngredientsColleague(final AID agentId, final JadescriptList<IngredientQuantity> ingredients) {
    return new RequestIngredientsColleague(agentId, __ListClass_IngredientQuantity.__fromList(ingredients));
  }

  public static ProvideIngredients ProvideIngredients(final JadescriptList<IngredientQuantity> ingredients, final Boolean whileProparing) {
    return new ProvideIngredients(__ListClass_IngredientQuantity.__fromList(ingredients), whileProparing);
  }

  public static NeedRestock NeedRestock(final AID agentId, final JadescriptList<IngredientQuantity> ingredients, final Boolean whileProparing) {
    return new NeedRestock(agentId, __ListClass_IngredientQuantity.__fromList(ingredients), whileProparing);
  }

  public static ProvidePackingList ProvidePackingList(final JadescriptList<PackageOfGoods> packageList) {
    return new ProvidePackingList(__ListClass_PackageOfGoods.__fromList(packageList));
  }

  public static class __ListClass_PackageOfGoods extends JadescriptList<PackageOfGoods> {
    public static __ListClass_PackageOfGoods __fromList(final JadescriptList<PackageOfGoods> list) {
      __ListClass_PackageOfGoods result = new __ListClass_PackageOfGoods();
      java.util.List<PackageOfGoods> elements = new java.util.ArrayList<>();
      list.forEach(elements::add);
      result.setElements(elements);
      return result;
    }
  }

  public static IngredientAvaliable IngredientAvaliable(final AID id, final Boolean avaliable, final JadescriptList<IngredientQuantity> ingredients) {
    return new IngredientAvaliable(id, avaliable, __ListClass_IngredientQuantity.__fromList(ingredients));
  }

  public static WorkerReady WorkerReady(final AID workerId, final String type) {
    return new WorkerReady(workerId, type);
  }

  public static PackerReady PackerReady(final AID workerId) {
    return new PackerReady(workerId);
  }

  public static SupplierRunOutSupply SupplierRunOutSupply(final Boolean bakerWhileProparing) {
    return new SupplierRunOutSupply(bakerWhileProparing);
  }

  public static OrderStatus OrderStatus(final String orderId, final String status) {
    return new OrderStatus(orderId, status);
  }

  public static AgentsReported AgentsReported() {
    return new AgentsReported();
  }

  public static EndOfPrivateOrders EndOfPrivateOrders() {
    return new EndOfPrivateOrders();
  }

  public static EndOfOrders EndOfOrders() {
    return new EndOfOrders();
  }

  public static RejectOrAcceptOrder RejectOrAcceptOrder(final String orderId, final String decision) {
    return new RejectOrAcceptOrder(orderId, decision);
  }

  public static RedoOrder RedoOrder(final String orderId) {
    return new RedoOrder(orderId);
  }

  public static GoodToPack GoodToPack(final Good good) {
    return new GoodToPack(good);
  }

  public static SubmitPackage SubmitPackage(final PackageOfGoods packageOfGoods) {
    return new SubmitPackage(packageOfGoods);
  }

  public static RejectPackage RejectPackage(final String packageId, final String reason) {
    return new RejectPackage(packageId, reason);
  }

  public static RepackedPackage RepackedPackage(final String packageId) {
    return new RepackedPackage(packageId);
  }

  public static PackageStatus PackageStatus(final PackageOfGoods package_, final String status) {
    return new PackageStatus(package_, status);
  }

  public static OrderRedoRequired OrderRedoRequired() {
    return new OrderRedoRequired();
  }

  public static PackageReady PackageReady() {
    return new PackageReady();
  }

  public static PackageRejected PackageRejected() {
    return new PackageRejected();
  }

  public BakeryOntology() {
    super(__NAME, jadescript.content.onto.Ontology.getInstance(), new jade.content.onto.CFReflectiveIntrospector());
    try {
    	add(new jade.content.schema.ConceptSchema("__ListClass_IngredientQuantity"), __ListClass_IngredientQuantity.class);;
    	add(new jade.content.schema.ConceptSchema("__ListClass_OrderQuantity"), __ListClass_OrderQuantity.class);;
    	add(new jade.content.schema.ConceptSchema("__ListClass_PackageOfGoods"), __ListClass_PackageOfGoods.class);;
    	
    	
    	add(new jade.content.schema.ConceptSchema(IngredientQuantity), IngredientQuantity.class);
    	add(new jade.content.schema.ConceptSchema(Good), Good.class);
    	add(new jade.content.schema.ConceptSchema(OrderQuantity), OrderQuantity.class);
    	add(new jade.content.schema.ConceptSchema(Order), Order.class);
    	add(new jade.content.schema.ConceptSchema(PackageOfGoods), PackageOfGoods.class);
    	add(new jade.content.schema.AgentActionSchema(RequestOrder), RequestOrder.class);
    	add(new jade.content.schema.AgentActionSchema(AssignOrder), AssignOrder.class);
    	add(new jade.content.schema.AgentActionSchema(RequestIngredients), RequestIngredients.class);
    	add(new jade.content.schema.AgentActionSchema(AskForHelpColleague), AskForHelpColleague.class);
    	add(new jade.content.schema.AgentActionSchema(RequestIngredientsColleague), RequestIngredientsColleague.class);
    	add(new jade.content.schema.AgentActionSchema(ProvideIngredients), ProvideIngredients.class);
    	add(new jade.content.schema.AgentActionSchema(NeedRestock), NeedRestock.class);
    	add(new jade.content.schema.AgentActionSchema(ProvidePackingList), ProvidePackingList.class);
    	add(new jade.content.schema.PredicateSchema(IngredientAvaliable), IngredientAvaliable.class);
    	add(new jade.content.schema.PredicateSchema(WorkerReady), WorkerReady.class);
    	add(new jade.content.schema.PredicateSchema(PackerReady), PackerReady.class);
    	add(new jade.content.schema.PredicateSchema(SupplierRunOutSupply), SupplierRunOutSupply.class);
    	add(new jade.content.schema.PredicateSchema(OrderStatus), OrderStatus.class);
    	add(new jade.content.schema.PredicateSchema(AgentsReported), AgentsReported.class);
    	add(new jade.content.schema.PredicateSchema(EndOfPrivateOrders), EndOfPrivateOrders.class);
    	add(new jade.content.schema.PredicateSchema(EndOfOrders), EndOfOrders.class);
    	add(new jade.content.schema.AgentActionSchema(RejectOrAcceptOrder), RejectOrAcceptOrder.class);
    	add(new jade.content.schema.AgentActionSchema(RedoOrder), RedoOrder.class);
    	add(new jade.content.schema.AgentActionSchema(GoodToPack), GoodToPack.class);
    	add(new jade.content.schema.AgentActionSchema(SubmitPackage), SubmitPackage.class);
    	add(new jade.content.schema.AgentActionSchema(RejectPackage), RejectPackage.class);
    	add(new jade.content.schema.AgentActionSchema(RepackedPackage), RepackedPackage.class);
    	add(new jade.content.schema.PredicateSchema(PackageStatus), PackageStatus.class);
    	add(new jade.content.schema.PredicateSchema(OrderRedoRequired), OrderRedoRequired.class);
    	add(new jade.content.schema.PredicateSchema(PackageReady), PackageReady.class);
    	add(new jade.content.schema.PredicateSchema(PackageRejected), PackageRejected.class);
    	
    	
    	jadescript.content.onto.Ontology.__populateListSchema((jade.content.schema.TermSchema) getSchema(IngredientQuantity), (jade.content.schema.ConceptSchema) getSchema("__ListClass_IngredientQuantity"));
    	jadescript.content.onto.Ontology.__populateListSchema((jade.content.schema.TermSchema) getSchema(OrderQuantity), (jade.content.schema.ConceptSchema) getSchema("__ListClass_OrderQuantity"));
    	jadescript.content.onto.Ontology.__populateListSchema((jade.content.schema.TermSchema) getSchema(PackageOfGoods), (jade.content.schema.ConceptSchema) getSchema("__ListClass_PackageOfGoods"));
    	
    	
    	jade.content.schema.ConceptSchema _csIngredientQuantity = (jade.content.schema.ConceptSchema) getSchema(IngredientQuantity);
    _csIngredientQuantity.add(IngredientQuantity_ingredientName, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    _csIngredientQuantity.add(IngredientQuantity_quantity, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.INTEGER));
    
    	jade.content.schema.ConceptSchema _csGood = (jade.content.schema.ConceptSchema) getSchema(Good);
    _csGood.add(Good_name, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    _csGood.add(Good_ingredients, (jade.content.schema.ConceptSchema) getSchema("__ListClass_IngredientQuantity"));
    _csGood.add(Good_bakingTime, (jade.content.schema.ConceptSchema) getSchema(jadescript.content.onto.Ontology.DURATION));
    _csGood.add(Good_preparationTime, (jade.content.schema.ConceptSchema) getSchema(jadescript.content.onto.Ontology.DURATION));
    _csGood.add(Good_batchSize, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.INTEGER));
    
    	jade.content.schema.ConceptSchema _csOrderQuantity = (jade.content.schema.ConceptSchema) getSchema(OrderQuantity);
    _csOrderQuantity.add(OrderQuantity_good, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    _csOrderQuantity.add(OrderQuantity_type, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    _csOrderQuantity.add(OrderQuantity_quantity, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.INTEGER));
    
    	jade.content.schema.ConceptSchema _csOrder = (jade.content.schema.ConceptSchema) getSchema(Order);
    _csOrder.add(Order_id, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    _csOrder.add(Order_good, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    _csOrder.add(Order_status, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    _csOrder.add(Order_type, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    
    	jade.content.schema.ConceptSchema _csPackageOfGoods = (jade.content.schema.ConceptSchema) getSchema(PackageOfGoods);
    _csPackageOfGoods.add(PackageOfGoods_packageId, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    _csPackageOfGoods.add(PackageOfGoods_ordersInPackage, (jade.content.schema.ConceptSchema) getSchema("__ListClass_OrderQuantity"));
    _csPackageOfGoods.add(PackageOfGoods_status, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    
    	jade.content.schema.AgentActionSchema _asRequestOrder = (jade.content.schema.AgentActionSchema) getSchema(RequestOrder);
    _asRequestOrder.add(RequestOrder_agentId, (jade.content.schema.ConceptSchema) getSchema(jade.content.lang.sl.SL0Vocabulary.AID));
    
    	jade.content.schema.AgentActionSchema _asAssignOrder = (jade.content.schema.AgentActionSchema) getSchema(AssignOrder);
    _asAssignOrder.add(AssignOrder_agentId, (jade.content.schema.ConceptSchema) getSchema(jade.content.lang.sl.SL0Vocabulary.AID));
    _asAssignOrder.add(AssignOrder_order, (jade.content.schema.ConceptSchema) getSchema(Order));
    
    	jade.content.schema.AgentActionSchema _asRequestIngredients = (jade.content.schema.AgentActionSchema) getSchema(RequestIngredients);
    _asRequestIngredients.add(RequestIngredients_agentId, (jade.content.schema.ConceptSchema) getSchema(jade.content.lang.sl.SL0Vocabulary.AID));
    _asRequestIngredients.add(RequestIngredients_ingredients, (jade.content.schema.ConceptSchema) getSchema("__ListClass_IngredientQuantity"));
    
    	jade.content.schema.AgentActionSchema _asAskForHelpColleague = (jade.content.schema.AgentActionSchema) getSchema(AskForHelpColleague);
    _asAskForHelpColleague.add(AskForHelpColleague_agentId, (jade.content.schema.ConceptSchema) getSchema(jade.content.lang.sl.SL0Vocabulary.AID));
    _asAskForHelpColleague.add(AskForHelpColleague_ingredients, (jade.content.schema.ConceptSchema) getSchema("__ListClass_IngredientQuantity"));
    
    	jade.content.schema.AgentActionSchema _asRequestIngredientsColleague = (jade.content.schema.AgentActionSchema) getSchema(RequestIngredientsColleague);
    _asRequestIngredientsColleague.add(RequestIngredientsColleague_agentId, (jade.content.schema.ConceptSchema) getSchema(jade.content.lang.sl.SL0Vocabulary.AID));
    _asRequestIngredientsColleague.add(RequestIngredientsColleague_ingredients, (jade.content.schema.ConceptSchema) getSchema("__ListClass_IngredientQuantity"));
    
    	jade.content.schema.AgentActionSchema _asProvideIngredients = (jade.content.schema.AgentActionSchema) getSchema(ProvideIngredients);
    _asProvideIngredients.add(ProvideIngredients_ingredients, (jade.content.schema.ConceptSchema) getSchema("__ListClass_IngredientQuantity"));
    _asProvideIngredients.add(ProvideIngredients_whileProparing, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.BOOLEAN));
    
    	jade.content.schema.AgentActionSchema _asNeedRestock = (jade.content.schema.AgentActionSchema) getSchema(NeedRestock);
    _asNeedRestock.add(NeedRestock_agentId, (jade.content.schema.ConceptSchema) getSchema(jade.content.lang.sl.SL0Vocabulary.AID));
    _asNeedRestock.add(NeedRestock_ingredients, (jade.content.schema.ConceptSchema) getSchema("__ListClass_IngredientQuantity"));
    _asNeedRestock.add(NeedRestock_whileProparing, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.BOOLEAN));
    
    	jade.content.schema.AgentActionSchema _asProvidePackingList = (jade.content.schema.AgentActionSchema) getSchema(ProvidePackingList);
    _asProvidePackingList.add(ProvidePackingList_packageList, (jade.content.schema.ConceptSchema) getSchema("__ListClass_PackageOfGoods"));
    
    	jade.content.schema.PredicateSchema _psIngredientAvaliable = (jade.content.schema.PredicateSchema) getSchema(IngredientAvaliable);
    _psIngredientAvaliable.add(IngredientAvaliable_id, (jade.content.schema.ConceptSchema) getSchema(jade.content.lang.sl.SL0Vocabulary.AID));
    _psIngredientAvaliable.add(IngredientAvaliable_avaliable, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.BOOLEAN));
    _psIngredientAvaliable.add(IngredientAvaliable_ingredients, (jade.content.schema.ConceptSchema) getSchema("__ListClass_IngredientQuantity"));
    
    	jade.content.schema.PredicateSchema _psWorkerReady = (jade.content.schema.PredicateSchema) getSchema(WorkerReady);
    _psWorkerReady.add(WorkerReady_workerId, (jade.content.schema.ConceptSchema) getSchema(jade.content.lang.sl.SL0Vocabulary.AID));
    _psWorkerReady.add(WorkerReady_type, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    
    	jade.content.schema.PredicateSchema _psPackerReady = (jade.content.schema.PredicateSchema) getSchema(PackerReady);
    _psPackerReady.add(PackerReady_workerId, (jade.content.schema.ConceptSchema) getSchema(jade.content.lang.sl.SL0Vocabulary.AID));
    
    	jade.content.schema.PredicateSchema _psSupplierRunOutSupply = (jade.content.schema.PredicateSchema) getSchema(SupplierRunOutSupply);
    _psSupplierRunOutSupply.add(SupplierRunOutSupply_bakerWhileProparing, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.BOOLEAN));
    
    	jade.content.schema.PredicateSchema _psOrderStatus = (jade.content.schema.PredicateSchema) getSchema(OrderStatus);
    _psOrderStatus.add(OrderStatus_orderId, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    _psOrderStatus.add(OrderStatus_status, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    
    	jade.content.schema.AgentActionSchema _asRejectOrAcceptOrder = (jade.content.schema.AgentActionSchema) getSchema(RejectOrAcceptOrder);
    _asRejectOrAcceptOrder.add(RejectOrAcceptOrder_orderId, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    _asRejectOrAcceptOrder.add(RejectOrAcceptOrder_decision, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    
    	jade.content.schema.AgentActionSchema _asRedoOrder = (jade.content.schema.AgentActionSchema) getSchema(RedoOrder);
    _asRedoOrder.add(RedoOrder_orderId, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    
    	jade.content.schema.AgentActionSchema _asGoodToPack = (jade.content.schema.AgentActionSchema) getSchema(GoodToPack);
    _asGoodToPack.add(GoodToPack_good, (jade.content.schema.ConceptSchema) getSchema(Good));
    
    	jade.content.schema.AgentActionSchema _asSubmitPackage = (jade.content.schema.AgentActionSchema) getSchema(SubmitPackage);
    _asSubmitPackage.add(SubmitPackage_packageOfGoods, (jade.content.schema.ConceptSchema) getSchema(PackageOfGoods));
    
    	jade.content.schema.AgentActionSchema _asRejectPackage = (jade.content.schema.AgentActionSchema) getSchema(RejectPackage);
    _asRejectPackage.add(RejectPackage_packageId, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    _asRejectPackage.add(RejectPackage_reason, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    
    	jade.content.schema.AgentActionSchema _asRepackedPackage = (jade.content.schema.AgentActionSchema) getSchema(RepackedPackage);
    _asRepackedPackage.add(RepackedPackage_packageId, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    
    	jade.content.schema.PredicateSchema _psPackageStatus = (jade.content.schema.PredicateSchema) getSchema(PackageStatus);
    _psPackageStatus.add(PackageStatus_package_, (jade.content.schema.ConceptSchema) getSchema(PackageOfGoods));
    _psPackageStatus.add(PackageStatus_status, (jade.content.schema.PrimitiveSchema) getSchema(jade.content.onto.BasicOntology.STRING));
    
    } catch (jade.content.onto.OntologyException e) {
    	e.printStackTrace();
    }
  }
}
