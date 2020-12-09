import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.HashSet;
import java.util.Set;

@SupportedAnnotationTypes("Transformer")
public class AnnotationProcessorExample extends AbstractProcessor {
    @Override
    public synchronized void init(ProcessingEnvironment env) {
        // Initialize the processor
        System.out.println("Hello");
    }
    @Override
    public boolean process(Set<? extends TypeElement> set,
                           RoundEnvironment roundEnv) {
        // Return the set of annotations supported
//        roundEnv.getElementsAnnotatedWith(Transformer.class)
//                .stream()
//                .filter(TypeElement.class::isInstance)
//                .map(TypeElement.class::cast)
//                .forEach(this::);

        return true;
    }
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> set = new HashSet<>();
        set.add(Transformer.class.getCanonicalName());
        return set;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        // Return the Java version supported
        return SourceVersion.latest();
    }

    /*
    private void generateTransformer(TypeElement orig) {
        TypeEntry clazz = EntryFactory.of(orig.asType());
        TransformerClass transformer = new TransformerClass(clazz, processingEnv);

        List<TypeEntry> fromTypes = TypeEntry.getTransformerClasses(clazz, "from");
        List<TypeEntry> toTypes = TypeEntry.getTransformerClasses(clazz, "to");

        fromTypes.forEach(c -> transformer.addTransformerMethod(TransformerMethod.of(c, clazz, "from"+c.getName())));
        toTypes.forEach(c -> transformer.addTransformerMethod(TransformerMethod.of(clazz, c, "to"+c.getName())));

        final Filer filer = processingEnv.getFiler();
        try {
            transformer.generate().writeTo(filer);
        } catch (IOException ex) {
            throw new TransformerProcessingException(orig, "could not output processing result to file '"
                    + clazz.getName() + "Transformer"
                    + "'.", ex);
        }
    }*/
}