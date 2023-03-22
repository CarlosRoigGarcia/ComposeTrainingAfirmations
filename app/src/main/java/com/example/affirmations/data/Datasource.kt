/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations.data
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {
     fun loadAffirmations(): List<Affirmation> {
        return listOf(
            Affirmation(1,R.string.affirmation1, R.drawable.image1,R.string.titleDescription,R.string.description,R.string.email1,R.string.phon1),
            Affirmation(2,R.string.affirmation2, R.drawable.image2,R.string.titleDescription,R.string.description,R.string.email2,R.string.phon2),
            Affirmation(3,R.string.affirmation3, R.drawable.image3,R.string.titleDescription,R.string.description,R.string.email3,R.string.phon3),
            Affirmation(4,R.string.affirmation4, R.drawable.image4,R.string.titleDescription,R.string.description,R.string.email4,R.string.phon4),
            Affirmation(5,R.string.affirmation5, R.drawable.image5,R.string.titleDescription,R.string.description,R.string.email5,R.string.phon5),
            Affirmation(6,R.string.affirmation6, R.drawable.image6,R.string.titleDescription,R.string.description,R.string.email6,R.string.phon6),
            Affirmation(7,R.string.affirmation7, R.drawable.image7,R.string.titleDescription,R.string.description,R.string.email7,R.string.phon7),
            Affirmation(8,R.string.affirmation8, R.drawable.image8,R.string.titleDescription,R.string.description,R.string.email8,R.string.phon8),
            Affirmation(9,R.string.affirmation9, R.drawable.image9,R.string.titleDescription,R.string.description,R.string.email9,R.string.phon9),
            Affirmation(10,R.string.affirmation10, R.drawable.image10,R.string.titleDescription,R.string.description,R.string.email10,R.string.phon10))
    }
}
