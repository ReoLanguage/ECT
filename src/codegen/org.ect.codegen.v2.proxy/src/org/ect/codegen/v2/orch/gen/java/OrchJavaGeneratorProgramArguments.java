package org.ect.codegen.v2.orch.gen.java;

import java.io.File;

import org.ect.codegen.v2.core.gen.AbstractGeneratorProgramArguments;

public class OrchJavaGeneratorProgramArguments extends
		AbstractGeneratorProgramArguments {

	private static final long serialVersionUID = 1L;

	//
	// FIELDS
	//

	/**
	 * Flag indicating if the "orcgen"-program should compile the orchestration
	 * it generates.
	 */
	public final boolean COMPILE;

	/**
	 * Path to the destination directory of the orchestration generated by the
	 * "proxygen"-program.
	 */
	public final String DESTINATION_PATH;

	/**
	 * Path to the <code>.reo</code> file to generate an orchestration for.
	 */
	public final String MODULE_PATH;

	/**
	 * Flag indicating if the "orcgen"-program should print the orchestration it
	 * generates.
	 */
	public final boolean PRINT;

	/**
	 * Paths, separated by {@link File#pathSeparator}, to the directories
	 * containing the non-Java resources on which compilation and execution of
	 * the orchestration generated by the "orcgen"-program depends.
	 */
	public final String ORC_RESOURCES_PATHS;

	/**
	 * Paths, separated by {@link File#pathSeparator}, to the directories
	 * containing the Java sources on which compilation and execution of the
	 * orchestration generated by the "orcgen"-program depends.
	 */
	public final String ORC_SOURCES_PATHS;

	/**
	 * Paths, separated by {@link File#pathSeparator}, to the template files
	 * used by the "orcgen"-program.
	 */
	public final String ORC_TEMPLATES_PATHS;

	//
	// CONSTRUCTORS
	//

	public OrchJavaGeneratorProgramArguments()
			throws AbstractGeneratorProgramArgumentsException {
		
		super("", "");

		this.COMPILE = false;
		this.PRINT = false;

		this.DESTINATION_PATH = null;
		this.MODULE_PATH = null;
		this.ORC_RESOURCES_PATHS = null;
		this.ORC_SOURCES_PATHS = null;
		this.ORC_TEMPLATES_PATHS = null;
	}

	public OrchJavaGeneratorProgramArguments(final Boolean compile,
			final String destinationPath, final String modulePath,
			final String orcResourcesPaths, final String orcSourcesPaths,
			final String orcTemplatesPaths, final Boolean print)
			throws OrcgenArgumentsException,
			AbstractGeneratorProgramArgumentsException {

		super("", "");

		try {
			this.COMPILE = compile == null ? false : compile;
			this.PRINT = print == null ? false : print;

			final OrchJavaGeneratorDefaults resolver = new OrchJavaGeneratorDefaults();
			this.MODULE_PATH = modulePath == null ? resolver.MODULE_PATH()
					: modulePath;
			this.ORC_RESOURCES_PATHS = orcResourcesPaths == null ? resolver
					.ORC_RESOURCES_PATHS() : orcResourcesPaths;
			this.ORC_SOURCES_PATHS = orcSourcesPaths == null ? resolver
					.ORC_SOURCES_PATHS() : orcSourcesPaths;
			this.ORC_TEMPLATES_PATHS = orcTemplatesPaths == null ? resolver
					.ORC_TEMPLATES_PATHS() : orcTemplatesPaths;

			this.DESTINATION_PATH = destinationPath == null ? resolver
					.DESTINATION_PATH(modulePath) : destinationPath;

		} catch (final Exception e) {
			throw new OrcgenArgumentsException(
					OrcgenArgumentsException.CONSTRUCTOR(
							OrchJavaGeneratorProgramArguments.class, compile,
							destinationPath, modulePath, orcResourcesPaths,
							orcSourcesPaths, orcTemplatesPaths, print), e);
		}
	}

	//
	// EXCEPTIONS
	//

	public static class OrcgenArgumentsException extends Exception {
		private static final long serialVersionUID = 1L;

		//
		// CONSTRUCTORS
		//

		protected OrcgenArgumentsException(final String message,
				final String cause) {
			super(message, new Throwable(cause));
		}

		protected OrcgenArgumentsException(final String message,
				final Throwable cause) {
			super(message, cause);
		}

		//
		// METHODS
		//

		protected static String CONSTRUCTOR(final Class<?> clazz,
				final Boolean compile, final String destinationPath,
				final String modulePath, final String orcResourcesPaths,
				final String orcSourcesPaths, final String orcTemplatesPaths,
				final Boolean print) {

			return "The class \"" + clazz.getCanonicalName()
					+ "\" failed to construct arguments.";
		}
	}
}
