/**
 * MIT License
 * <p>
 * Copyright (c) 2018 Darren Forsythe
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.flaw101.concat;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import io.github.flaw101.concat.filewriter.setup.DirectorySetup;
import io.github.flaw101.concat.filewriter.setup.OutputSetup;
import io.github.flaw101.concat.filewriter.setup.SemanticVersioningSetup;
import io.github.flaw101.concat.validate.DirectoryValidator;
import io.github.flaw101.concat.validate.FileListValidator;
import io.github.flaw101.concat.validate.Validator;

/**
 * Guice Module to setup non-concrete classes.
 *
 * @author Darren Forsythe
 * @since 1.1.2
 */
public class ConcatModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Validator.class).annotatedWith(Names.named("FileList"))
                .to(FileListValidator.class);
        bind(Validator.class).annotatedWith(Names.named("Directory"))
                .to(DirectoryValidator.class);
        bind(OutputSetup.class).annotatedWith(Names.named("DirectorySetup")).to(DirectorySetup.class);
        bind(OutputSetup.class).annotatedWith(Names.named("SemVerSetup")).to(SemanticVersioningSetup.class);
    }

}
